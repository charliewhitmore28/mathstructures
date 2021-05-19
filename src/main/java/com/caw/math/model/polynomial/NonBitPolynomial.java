package com.caw.math.model.polynomial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * An implementation of {@link ModularPolynomial} that handles polynomials with a modulus of greater than two. If using
 * a {@code ModularPolynomial} with a modulus of two, {@link BitPolynomial} should be used, as this class sacrifices
 * speed and memory in order to provide correctness in complex cases.
 *
 * @author cwhitmore
 */

@SuppressWarnings("PMD.TooManyMethods")
public class NonBitPolynomial implements ModularPolynomial {

    private final BigInteger value;
    private final BigInteger modulus;

    /* default */ NonBitPolynomial(final BigInteger value,
                     final BigInteger modulus) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid " + getClass().getSimpleName() + ": value=" + value);
        }
        if (modulus.compareTo(BigInteger.TWO) <= 0) {
            throw new IllegalArgumentException("Invalid " + getClass().getSimpleName() + ": modulus=" + modulus);
        }
        this.value = value;
        this.modulus = modulus;
    }

    /* default */ NonBitPolynomial(final List<BigInteger> coefficients,
                     final BigInteger modulus) {
        this(ModularPolynomial.valueOf(coefficients, modulus), modulus);
    }

    /* default */ NonBitPolynomial(final BigInteger value,
                     final long modulus) {
        this(value, BigInteger.valueOf(modulus));
    }

    /* default */ NonBitPolynomial(final long value,
                     final long modulus) {
        this(BigInteger.valueOf(value), BigInteger.valueOf(modulus));
    }

    @Override
    public ModularPolynomial accepts(final ModularPolynomialVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public NonBitPolynomial add(final ModularPolynomial addend) {
        return add(addend.value());
    }

    @Override
    public NonBitPolynomial add(final BigInteger polynomial) {

        final List<BigInteger> augend = coefficients();
        final List<BigInteger> addend = ModularPolynomial.coefficientsOf(polynomial, this.modulus);
        final int sumLength = Math.max(augend.size(), addend.size());
        final List<BigInteger> sum = new ArrayList<>(sumLength);

        for (int i = 0; i < sumLength; i++) {
            sum.add(coefficient(augend, i).add(coefficient(addend, i)));
        }
        return new NonBitPolynomial(sum, this.modulus);
    }

    @Override
    public NonBitPolynomial add(final long addend) {
        return add(BigInteger.valueOf(addend));
    }

    @Override
    public List<BigInteger> coefficients() {
        return ModularPolynomial.coefficientsOf(this);
    }



    @Override
    public int degree() {
        int degree = 0;
        BigInteger ceiling = this.modulus;

        while (this.value.compareTo(ceiling) >= 0) {
            degree++;
            ceiling = ceiling.multiply(this.modulus);
        }

        return degree;
    }

    @Override
    public BigInteger modulus() {
        return this.modulus;
    }

    @Override
    public NonBitPolynomial multiply(final ModularPolynomial multiplier) {
        return multiply(multiplier.value());
    }

    @Override
    public NonBitPolynomial multiply(final BigInteger polynomial) {

        final List<BigInteger> multiplicand = coefficients();
        final List<BigInteger> multiplier = ModularPolynomial.coefficientsOf(polynomial, this.modulus);
        final int multiplicandLength = multiplicand.size();
        final int multiplierLength = multiplier.size();
        final List<BigInteger> product = new ArrayList<>(Collections.nCopies(multiplicandLength + multiplierLength - 1, BigInteger.ZERO));

        for (int multiplicandIndex = 0; multiplicandIndex < multiplicandLength; multiplicandIndex++) {
            for (int multiplierIndex = 0; multiplierIndex < multiplierLength; multiplierIndex++) {

                final BigInteger raw = coefficient(multiplicand, multiplicandIndex).multiply(coefficient(multiplier, multiplierIndex));
                merge(product, raw, BigInteger::add, multiplicandIndex + multiplierIndex);
            }
        }
        return new NonBitPolynomial(product, this.modulus);
    }

    @Override
    public NonBitPolynomial multiply(final long multiplier) {
        return multiply(BigInteger.valueOf(multiplier));
    }

    @Override
    public NonBitPolynomial scale(final BigInteger factor) {

        final List<BigInteger> newCoefficients = new ArrayList<>();
        for (final BigInteger coefficient : coefficients()) {
            newCoefficients.add(coefficient.multiply(factor));
        }
        return new NonBitPolynomial(newCoefficients, this.modulus);
    }

    @Override
    public NonBitPolynomial scale(final long factor) {
        return scale(BigInteger.valueOf(factor));
    }

    @Override
    public NonBitPolynomial subtract(final ModularPolynomial subtrahend) {
        return subtract(subtrahend.value());
    }

    @Override
    public NonBitPolynomial subtract(final BigInteger polynomial) {

        final List<BigInteger> minuend = coefficients();
        final List<BigInteger> subtrahend = ModularPolynomial.coefficientsOf(polynomial, this.modulus);
        final int differenceLength = Math.max(minuend.size(), subtrahend.size());
        final List<BigInteger> difference = new ArrayList<>(differenceLength);

        for (int i = 0; i < differenceLength; i++) {
            difference.add(coefficient(minuend, i).subtract(coefficient(subtrahend, i)));
        }
        return new NonBitPolynomial(difference, this.modulus);
    }

    @Override
    public NonBitPolynomial subtract(final long subtrahend) {
        return subtract(BigInteger.valueOf(subtrahend));
    }

    @Override
    @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
    public String toString() {

        final List<BigInteger> coefficients = coefficients();
        final StringBuilder builder = new StringBuilder();
        boolean initial = true;

        int degree = 0;
        for (final BigInteger coefficient : coefficients) {
            if (!coefficient.equals(BigInteger.ZERO)) {
                if (!initial) {
                    builder.insert(0, " + ");
                }
                final String prefix = coefficient.equals(BigInteger.ONE) ? "" : String.valueOf(coefficient);
                if (degree > 1) {
                    builder.insert(0, prefix + "x^" + degree);
                } else if (degree == 1) {
                    builder.insert(0, prefix + 'x');
                } else if (degree == 0) {
                    builder.insert(0, coefficient.longValueExact());
                }
                initial = false;
            }
            degree++;
        }

        if (builder.length() == 0) {
            builder.append('0');
        }

        return builder.toString();
    }

    @Override
    public BigInteger value() {
        return this.value;
    }

    /**
     * Safely retrieve the coefficient from a list of coefficients making up a {@link NonBitPolynomial}.
     * This method returns {@link BigInteger#ZERO} if a coefficient cannot be found at the specified
     * {@code index} in the list of coefficients.
     *
     * @param coefficients
     *      The {@link List} of coefficients to retrieve the coefficient from.
     * @param index
     *      The index in the list to retrieve the coefficient from.
     * @return
     *      The coefficient from the list of coefficients at the specified index, {@code BigInteger.ZERO} if none.
     */

    private BigInteger coefficient(final List<BigInteger> coefficients,
                                   final int index) {
        return index < coefficients.size() ? coefficients.get(index) : BigInteger.ZERO;
    }

    /**
     * Merge the specified {@code value} into the specified {@link List} of {@code coefficients} at index {@code index},
     * using the specified {@link BinaryOperator} {@code operator}. Before updating the coefficient, the value to merge
     * is reduced using the modulus of this polynomial.
     *
     * @param coefficients
     *      The list of coefficients that the value will be merged into.
     * @param value
     *      The value to merge into the list of coefficients.
     * @param operator
     *      The operator to use while merging the new {@code value} with the existing value in the list of coefficients.
     * @param index
     *      The index in the list of coefficients to merge the value into.
     */

    private void merge(final List<BigInteger> coefficients,
                       final BigInteger value,
                       final BinaryOperator<BigInteger> operator,
                       final int index) {

        final BigInteger newValue = operator.apply(coefficients.get(index), value);
        coefficients.set(index, newValue);
    }

}
