package com.caw.math.group.field.galois;

import com.caw.math.group.field.galois.algorithm.inverse.GaloisInverse;
import com.caw.math.group.field.galois.algorithm.inverse.GaloisInverseFactory;
import com.caw.math.model.polynomial.ModularPolynomial;
import com.caw.math.model.polynomial.ModularPolynomialFactory;
import com.caw.math.model.polynomial.ModularPolynomialVisitor;

import java.math.BigInteger;

/**
 * An extension of {@link AbstractGaloisField} which describes a {@link GaloisField} of {@link GaloisPolynomialElement}
 * elements.
 *
 * @author cwhitmore
 */

public class GaloisPolynomialField extends AbstractGaloisField {

    // TODO:: IoC?
    private final GaloisInverse galoisInverse = GaloisInverseFactory.make();
    private final ModularPolynomialVisitor reducer;

    public GaloisPolynomialField(final BigInteger prime,
                                 final int primePower,
                                 final BigInteger irreduciblePolynomial) {
        super(prime, primePower);
        this.reducer = new ModularPolynomialReducer(this, irreduciblePolynomial);
    }

    public GaloisPolynomialField(final long prime,
                                 final int primePower,
                                 final long irreduciblePolynomial) {
        this(BigInteger.valueOf(prime), primePower, BigInteger.valueOf(irreduciblePolynomial));
    }

    @Override
    public GaloisElement add(final BigInteger augend, final BigInteger addend) {
        final ModularPolynomial modularPolynomial = ModularPolynomialFactory.fromValue()
                .withValue(augend)
                .withModulus(prime())
                .build();
        final ModularPolynomial sum = modularPolynomial.add(addend);
        return new GaloisPolynomialElement(this, sum.value());
    }

    @Override
    public GaloisElement additiveInverseOf(final BigInteger value) {
        final ModularPolynomial modularPolynomial = ModularPolynomialFactory.fromValue()
                .withValue(BigInteger.ZERO)
                .withModulus(prime())
                .build();
        final ModularPolynomial difference = modularPolynomial.subtract(value);
        return new GaloisPolynomialElement(this, difference.value());
    }

    @Override
    public GaloisElement divide(final BigInteger dividend, final BigInteger divisor) {
        final GaloisElement multiplier = multiplicativeInverseOf(divisor);
        return multiply(dividend, multiplier.value());
    }

    @Override
    public GaloisElement element(final BigInteger value) {
        return new GaloisPolynomialElement(this, value);
    }

    @Override
    public GaloisElement element(final long value) {
        return new GaloisPolynomialElement(this, value);
    }

    @Override
    public GaloisElement getAdditiveNeutralElement() {
        return new GaloisPolynomialElement(this, BigInteger.ZERO);
    }

    @Override
    public GaloisElement getMultiplicativeNeutralElement() {
        return new GaloisPolynomialElement(this, BigInteger.ONE);
    }

    @Override
    public GaloisElement multiplicativeInverseOf(final BigInteger value) {
        return galoisInverse.invert(this, value);
    }

    @Override
    public GaloisElement multiply(final BigInteger multiplicand, final BigInteger multiplier) {
        final ModularPolynomial modularPolynomial = ModularPolynomialFactory.fromValue()
                .withValue(multiplicand)
                .withModulus(prime())
                .build();
        final ModularPolynomial product = modularPolynomial.multiply(multiplier);
        return new GaloisPolynomialElement(this, product.value());
    }

    @Override
    public BigInteger reduce(final BigInteger value) {
        final ModularPolynomial modularPolynomial = ModularPolynomialFactory.fromValue()
                .withValue(value)
                .withModulus(prime())
                .build();
        final ModularPolynomial reduced = modularPolynomial.accepts(reducer);
        return reduced.value();
    }

    @Override
    public GaloisElement subtract(final BigInteger minuend, final BigInteger subtrahend) {
        final ModularPolynomial modularPolynomial = ModularPolynomialFactory.fromValue()
                .withValue(minuend)
                .withModulus(prime())
                .build();
        final ModularPolynomial difference = modularPolynomial.subtract(subtrahend);
        return new GaloisPolynomialElement(this, difference.value());
    }
}
