package com.caw.math.group.field.galois;

import java.math.BigInteger;

/**
 * A base class for {@link GaloisField} implementations.
 *
 * @author cwhitmore
 */

@SuppressWarnings("PMD.TooManyMethods")
public abstract class AbstractGaloisField implements GaloisField {

    private static final int MIN_PRIME_POWER = 1;

    private final BigInteger prime;
    private final int primePower;
    private final BigInteger size;

    /* default */ AbstractGaloisField(final BigInteger prime, final int primePower) {
        if (!prime.isProbablePrime(100)) {
            throw new IllegalArgumentException("Invalid " + getClass() + ": prime=" + prime);
        }
        if (primePower < MIN_PRIME_POWER) {
            throw new IllegalArgumentException("Invalid " + getClass() + ": primePower=" + primePower);
        }
        this.prime = prime;
        this.primePower = primePower;
        this.size = prime.pow(primePower);
    }

    @Override
    public GaloisElement add(final GaloisElement augend, final GaloisElement addend) {
        return add(augend.value(), addend.value());
    }

    @Override
    public GaloisElement add(final long augend, final long addend) {
        return add(BigInteger.valueOf(augend), BigInteger.valueOf(addend));
    }

    @Override
    public GaloisElement additiveInverseOf(final GaloisElement element) {
        return additiveInverseOf(element.value());
    }

    @Override
    public GaloisElement additiveInverseOf(final long value) {
        return additiveInverseOf(BigInteger.valueOf(value));
    }

    @Override
    public GaloisElement divide(final GaloisElement dividend, final GaloisElement divisor) {
        return divide(dividend.value(), divisor.value());
    }

    @Override
    public GaloisElement divide(final long dividend, final long divisor) {
        return divide(BigInteger.valueOf(dividend), BigInteger.valueOf(divisor));
    }

    @Override
    public GaloisElement multiplicativeInverseOf(final GaloisElement element) {
        return multiplicativeInverseOf(element.value());
    }

    @Override
    public GaloisElement multiplicativeInverseOf(final long value) {
        return multiplicativeInverseOf(BigInteger.valueOf(value));
    }

    @Override
    public GaloisElement multiply(final GaloisElement multiplicand, final GaloisElement multiplier) {
        return multiply(multiplicand.value(), multiplier.value());
    }

    @Override
    public GaloisElement multiply(final long multiplicand, final long multiplier) {
        return multiply(BigInteger.valueOf(multiplicand), BigInteger.valueOf(multiplier));
    }

    @Override
    public GaloisElement subtract(final GaloisElement minuend, final GaloisElement subtrahend) {
        return subtract(minuend.value(), subtrahend.value());
    }

    @Override
    public GaloisElement subtract(final long minuend, final long subtrahend) {
        return subtract(BigInteger.valueOf(minuend), BigInteger.valueOf(subtrahend));
    }

    @Override
    public BigInteger prime() {
        return prime;
    }

    @Override
    public int primePower() {
        return primePower;
    }

    @Override
    public BigInteger size() {
        return size;
    }


}
