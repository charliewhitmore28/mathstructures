package com.caw.math.group.ring;

import com.caw.math.group.AdditionGroup;
import com.caw.math.group.ring.algorithm.phi.Phi;
import com.caw.math.group.ring.algorithm.phi.PhiFactory;

import java.math.BigInteger;

/**
 * An implementation of an {@link AdditionGroup} that represents an integer ring.
 * An integer ring is a finite group that supports the addition operation.
 * It is not guaranteed to support other operations such as multiplicative operations but it may depending on the size
 * of the integer ring.
 *
 * @author cwhitmore
 */

@SuppressWarnings("PMD.TooManyMethods")
public class IntegerRing implements AdditionGroup<IntegerRingElement> {

    // TODO:: IoC?
    private final Phi phi = PhiFactory.make();
    private final BigInteger size;

    public IntegerRing(final BigInteger size) {
        this.size = size;
    }

    public IntegerRing(final long size) {
        this(BigInteger.valueOf(size));
    }

    @Override
    public IntegerRingElement add(final IntegerRingElement augend, final IntegerRingElement addend) {
        return add(augend.value(), addend.value());
    }

    @Override
    public IntegerRingElement add(final BigInteger augend, final BigInteger addend) {
        final BigInteger sum = augend.add(addend);
        return new IntegerRingElement(this, sum);
    }

    @Override
    public IntegerRingElement add(final long augend, final long addend) {
        return add(BigInteger.valueOf(augend), BigInteger.valueOf(addend));
    }

    @Override
    public IntegerRingElement additiveInverseOf(final IntegerRingElement element) {
        return additiveInverseOf(element.value());
    }

    @Override
    public IntegerRingElement additiveInverseOf(final BigInteger value) {
        final BigInteger additiveInverse = size.subtract(value);
        return new IntegerRingElement(this, additiveInverse);
    }

    @Override
    public IntegerRingElement additiveInverseOf(final long value) {
        return additiveInverseOf(BigInteger.valueOf(value));
    }

    @Override
    public IntegerRingElement getAdditiveNeutralElement() {
        return new IntegerRingElement(this, BigInteger.ZERO);
    }

    /**
     * Returns a new {@link IntegerRingElement} instance with the specified {@code value}, which may have been reduced
     * depending on the size of this integer ring.
     *
     * @param value
     *      The value to create a new {@link IntegerRingElement} with.
     * @return
     *      A new {@link IntegerRingElement} with the specified value.
     */

    public IntegerRingElement element(final BigInteger value) {
        return new IntegerRingElement(this, value);
    }

    /**
     * Returns a new {@link IntegerRingElement} instance with the specified {@code value}, which may have been reduced
     * depending on the size of this integer ring.
     *
     * @param value
     *      The value to create a new {@link IntegerRingElement} with.
     * @return
     *      A new {@link IntegerRingElement} with the specified value.
     */

    public IntegerRingElement element(final long value) {
        return new IntegerRingElement(this, value);
    }

    /**
     * Report the phi-value of this IntegerRing.
     *
     * @return
     *      The phi-value of this integer ring.
     */

    public BigInteger phi() {
        return phi.of(this);
    }

    @Override
    public IntegerRingElement subtract(final IntegerRingElement minuend, final IntegerRingElement subtrahend) {
        return subtract(minuend.value(), subtrahend.value());
    }

    @Override
    public IntegerRingElement subtract(final BigInteger minuend, final BigInteger subtrahend) {
        final BigInteger difference = minuend.subtract(subtrahend);
        return new IntegerRingElement(this, difference);
    }

    @Override
    public IntegerRingElement subtract(final long minuend, final long subtrahend) {
        return subtract(BigInteger.valueOf(minuend), BigInteger.valueOf(subtrahend));
    }

    /**
     * Reports the size of this integer ring.
     *
     * @return
     *      The size of this integer ring.
     */

    public BigInteger size() {
        return size;
    }

}
