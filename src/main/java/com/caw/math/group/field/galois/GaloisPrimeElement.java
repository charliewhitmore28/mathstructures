package com.caw.math.group.field.galois;

import java.math.BigInteger;

/**
 * An extension of an {@link AbstractGaloisElement} which represents a member of a {@link GaloisPrimeField}.
 *
 * @author cwhitmore
 */

public class GaloisPrimeElement extends AbstractGaloisElement {

    /* default */ GaloisPrimeElement(final GaloisPrimeField field, final BigInteger value) {
        super(field, value);
    }

    /* default */ GaloisPrimeElement(final GaloisPrimeField field, final long value) {
        this(field, BigInteger.valueOf(value));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[value=" + value() + "]";
    }

}
