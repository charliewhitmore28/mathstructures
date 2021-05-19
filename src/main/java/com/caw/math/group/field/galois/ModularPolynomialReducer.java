package com.caw.math.group.field.galois;

import com.caw.math.model.polynomial.*;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 * An implementation of {@link ModularPolynomialVisitor} which provides algorithms for reducing the polynomial value
 * of a {@link ModularPolynomial} inside of a {@link GaloisField} for the different implementations of
 * {@code ModularPolynomial}.
 *
 * @author cwhitmore
 */

public class ModularPolynomialReducer implements ModularPolynomialVisitor {

    private final GaloisField field;
    private final ModularPolynomial reducer;

    public ModularPolynomialReducer(final GaloisField field,
                                    final ModularPolynomial reducer) {
        this.field = field;
        this.reducer = reducer;
    }

    public ModularPolynomialReducer(final GaloisField field,
                                    final BigInteger reducer) {
        this(field, ModularPolynomialFactory.fromValue().withValue(reducer).withModulus(field.prime()).build());
    }

    public ModularPolynomialReducer(final GaloisField field,
                                    final long reducer) {
        this(field, BigInteger.valueOf(reducer));
    }

    @Override
    public ModularPolynomial visit(final BitPolynomial polynomial) {

        final int degreeDiff = polynomial.degree() - reducer.degree();
        if (degreeDiff < 0) {
            return polynomial;
        } else {
            final BigInteger shifted = reducer.value().shiftLeft(degreeDiff);
            final ModularPolynomial reduced = ModularPolynomialFactory.fromValue()
                    .withValue(polynomial.value().xor(shifted))
                    .withModulus(polynomial.modulus())
                    .build();
            return reduced.accepts(this);
        }
    }

    @Override
    public ModularPolynomial visit(final NonBitPolynomial polynomial) {

        final int degreeDiff = polynomial.degree() - reducer.degree();

        if (degreeDiff < 0) {
            return polynomial;
        } else {

            final List<BigInteger> polynomialCoefficients = polynomial.coefficients();
            final List<BigInteger> reducerCoefficients = reducer.coefficients();

            // Shift the irreducible polynomial until the degree of the shifted reducer equals the degree of the
            // polynomial to reduce.
            final List<BigInteger> shifter = Collections.nCopies(polynomialCoefficients.size() - reducerCoefficients.size(), BigInteger.ZERO);
            reducerCoefficients.addAll(0, shifter);
            final ModularPolynomial shiftedReducer = ModularPolynomialFactory.fromCoefficients()
                    .withCoefficients(reducerCoefficients)
                    .withModulus(field.prime())
                    .build();

            final BigInteger leadingPolynomialCoefficient = polynomialCoefficients.get(polynomialCoefficients.size() - 1);
            final BigInteger leadingReducerCoefficient = reducerCoefficients.get(reducerCoefficients.size() - 1);

            // Calculate the scale factor required such that the highest degree coefficient of the reducer polynomial
            // is equal to the highest degree coefficient of the polynomial to reduce.
            final GaloisField primeField = new GaloisPrimeField(field.prime());
            final GaloisElement leadingReducerInverse = primeField.multiplicativeInverseOf(leadingReducerCoefficient);
            final BigInteger factor = leadingReducerInverse.multiply(leadingPolynomialCoefficient).value().mod(field.prime());

            final ModularPolynomial scaledReducer = shiftedReducer.scale(factor);
            final NonBitPolynomial reduced = polynomial.subtract(scaledReducer);

            // One reduction operation is guaranteed to lower the degree of the polynomial to reduce, however does not
            // guarantee that we have made it all the way to being a member of this reducer's galois field.
            return reduced.accepts(this);
        }
    }
}
