package com.caw.math.group.ring;

import com.caw.math.group.AdditionGroupElement;

import java.math.BigInteger;

/**
 * An extension of {@link AdditionGroupElement} that is a member of an {@link IntegerRing}. Integer ring elements are
 * immutable, with mathematical operations returning new integer ring element instances.
 *
 * @author cwhitmore.
 */

public class IntegerRingElement implements AdditionGroupElement {

    private final IntegerRing ring;
    private final BigInteger value;

    /* default */ IntegerRingElement(final IntegerRing ring, final BigInteger value) {
        this.ring = ring;
        this.value = value.mod(ring.size());
    }

    /* default */ IntegerRingElement(final IntegerRing ring, final long value) {
        this(ring, BigInteger.valueOf(value));
    }

    @Override
    public IntegerRingElement add(final AdditionGroupElement addend) {
        return ring.add(value, addend.value());
    }

    @Override
    public IntegerRingElement add(final BigInteger addend) {
        return ring.add(value, addend);
    }

    @Override
    public IntegerRingElement add(final long addend) {
        return ring.add(value, BigInteger.valueOf(addend));
    }

    @Override
    public IntegerRingElement additiveInverse() {
        return ring.additiveInverseOf(this);
    }

    @Override
    public IntegerRingElement subtract(final AdditionGroupElement subtrahend) {
        return ring.subtract(value, subtrahend.value());
    }

    @Override
    public IntegerRingElement subtract(final BigInteger subtrahend) {
        return ring.subtract(value, subtrahend);
    }

    @Override
    public IntegerRingElement subtract(final long subtrahend) {
        return ring.subtract(value, BigInteger.valueOf(subtrahend));
    }

    @Override
    public BigInteger value() {
        return value;
    }
}
