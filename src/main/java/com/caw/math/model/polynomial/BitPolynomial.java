package com.caw.math.model.polynomial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of {@link ModularPolynomial} for polynomials with a modulus of two. This allows for mathematical
 * operations to be completed very quickly and efficiently using simple bit-arithmetic. For modulus values of greater
 * than two, {@link NonBitPolynomial} must be used.
 *
 * @author cwhitmore
 */

@SuppressWarnings("PMD.TooManyMethods")
public class BitPolynomial implements ModularPolynomial {

    private static final BigInteger MODULUS = BigInteger.TWO;

    private final BigInteger value;

    /* default */ BitPolynomial(final BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid " + getClass().getSimpleName() + ": value=" + value);
        }
        this.value = value;
    }

    /* default */ BitPolynomial(final List<BigInteger> coefficients) {
        this(ModularPolynomial.valueOf(coefficients, MODULUS));
    }

    /* default */ BitPolynomial(final long value) {
        this(BigInteger.valueOf(value));
    }

    @Override
    public ModularPolynomial accepts(final ModularPolynomialVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public BitPolynomial add(final ModularPolynomial addend) {
        return add(addend.value());
    }

    @Override
    public BitPolynomial add(final BigInteger addend) {
        return new BitPolynomial(this.value.xor(addend));
    }

    @Override
    public BitPolynomial add(final long addend) {
        return add(BigInteger.valueOf(addend));
    }

    @Override
    public List<BigInteger> coefficients() {
        final List<BigInteger> coefficients = new ArrayList<>();

        for (int i = 0; i < this.value.bitLength(); i++) {
            if (this.value.testBit(i)) {
                coefficients.add(BigInteger.ONE);
            } else {
                coefficients.add(BigInteger.ZERO);
            }
        }

        return coefficients;
    }

    @Override
    public int degree() {
        return this.value.bitLength() > 0 ? this.value.bitLength() - 1 : 0;
    }

    @Override
    public BigInteger modulus() {
        return MODULUS;
    }

    @Override
    public BitPolynomial multiply(final ModularPolynomial multiplier) {
        return multiply(multiplier.value());
    }

    @Override
    public BitPolynomial multiply(final BigInteger multiplier) {

        BigInteger product = BigInteger.ZERO;
        BigInteger shiftedMultiplier = multiplier;
        for (int i = 0; i < this.value.bitLength(); i++) {
            if (this.value.testBit(i)) {
                product = product.xor(shiftedMultiplier);
            }
            shiftedMultiplier = shiftedMultiplier.shiftLeft(1);
        }

        return new BitPolynomial(product);
    }

    @Override
    public BitPolynomial multiply(final long multiplier) {
        return multiply(BigInteger.valueOf(multiplier));
    }

    @Override
    public BitPolynomial scale(final BigInteger factor) {

        if (factor.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            return new BitPolynomial(BigInteger.ZERO);
        } else {
            return this;
        }
    }

    @Override
    public BitPolynomial scale(final long factor) {
        return scale(BigInteger.valueOf(factor));
    }

    @Override
    public BitPolynomial subtract(final ModularPolynomial subtrahend) {
        return subtract(subtrahend.value());
    }

    @Override
    public BitPolynomial subtract(final BigInteger subtrahend) {
        return new BitPolynomial(this.value.xor(subtrahend));
    }

    @Override
    public BitPolynomial subtract(final long subtrahend) {
        return subtract(BigInteger.valueOf(subtrahend));
    }

    @Override
    @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        final StringBuilder prepender = new StringBuilder();

        for (int i = 0; i < this.value.bitLength(); i++) {
            if (this.value.testBit(i)) {
                if (i == 0) {
                    builder.append('1');
                } else {
                    prepender.setLength(0);
                    prepender.append('x');
                    if (i != 1) {
                        prepender.append('^').append(i);
                    }
                    if (builder.length() != 0) {
                        prepender.append(" + ");
                    }
                    builder.insert(0, prepender);
                }
            }
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
}
