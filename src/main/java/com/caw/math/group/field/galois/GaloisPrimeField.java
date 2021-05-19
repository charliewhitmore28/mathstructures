package com.caw.math.group.field.galois;

import com.caw.math.group.field.galois.algorithm.inverse.GaloisInverse;
import com.caw.math.group.field.galois.algorithm.inverse.GaloisInverseFactory;

import java.math.BigInteger;

/**
 * An extension of an {@link AbstractGaloisField} which describes a {@link GaloisField} of {@link GaloisPrimeElement}
 * elements.
 *
 * @author cwhitmore
 */

public class GaloisPrimeField extends AbstractGaloisField {

    // TODO: IoC?
    private final GaloisInverse galoisInverse = GaloisInverseFactory.make();

    public GaloisPrimeField(final BigInteger prime) {
        super(prime, 1);
    }

    public GaloisPrimeField(final long prime) {
        this(BigInteger.valueOf(prime));
    }

    @Override
    public GaloisElement add(final BigInteger augend, final BigInteger addend) {
        final BigInteger sum = augend.add(addend);
        return new GaloisPrimeElement(this, sum);
    }

    @Override
    public GaloisElement additiveInverseOf(final BigInteger value) {
        final BigInteger inverse = prime().subtract(value);
        return new GaloisPrimeElement(this, inverse);
    }

    @Override
    public GaloisElement divide(final BigInteger dividend, final BigInteger divisor) {
        final BigInteger divisorInverse = galoisInverse.invert(this, divisor).value();
        return multiply(dividend, divisorInverse);
    }

    @Override
    public GaloisElement element(final BigInteger value) {
        return new GaloisPrimeElement(this, value);
    }

    @Override
    public GaloisElement element(final long value) {
        return new GaloisPrimeElement(this, value);
    }

    @Override
    public GaloisElement getAdditiveNeutralElement() {
        return new GaloisPrimeElement(this, BigInteger.ZERO);
    }

    @Override
    public GaloisElement getMultiplicativeNeutralElement() {
        return new GaloisPrimeElement(this, BigInteger.ONE);
    }

    @Override
    public GaloisElement multiplicativeInverseOf(final BigInteger value) {
        return galoisInverse.invert(this, value);
    }

    @Override
    public GaloisElement multiply(final BigInteger multiplicand, final BigInteger multiplier) {
        final BigInteger product = multiplicand.multiply(multiplier);
        return new GaloisPrimeElement(this, product);
    }

    @Override
    public BigInteger reduce(final BigInteger value) {
        return value.mod(prime());
    }

    @Override
    public GaloisElement subtract(final BigInteger minuend, final BigInteger subtrahend) {
        final BigInteger difference = minuend.subtract(subtrahend);
        return new GaloisPrimeElement(this, difference);
    }
}
