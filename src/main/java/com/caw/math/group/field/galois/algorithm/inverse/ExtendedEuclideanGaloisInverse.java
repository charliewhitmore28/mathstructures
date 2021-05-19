package com.caw.math.group.field.galois.algorithm.inverse;

import com.caw.math.group.field.galois.GaloisElement;
import com.caw.math.group.field.galois.GaloisField;

import java.math.BigInteger;

/**
 * An implementation of a {@link GaloisInverse} algorithm for finding multiplicative inverses of {@link GaloisElement}
 * elements inside of a {@link GaloisField}.
 *
 * TODO:: Where is the reduction logic? How would this work for polynomial fields..
 *
 * @author cwhitmore
 */

public class ExtendedEuclideanGaloisInverse implements GaloisInverse {

    /* default */ ExtendedEuclideanGaloisInverse() {
        // disable non-default instantiation.
    }

    @Override
    public GaloisElement invert(final GaloisElement element) {
        return invert(element.field(), element.value());
    }

    @Override
    public GaloisElement invert(final GaloisField field, final BigInteger value) {

        BigInteger min = value;

        if (min.equals(BigInteger.ZERO)) {
            return field.element(BigInteger.ZERO);
        }
        if (min.equals(BigInteger.ONE)) {
            return field.element(BigInteger.ONE);
        }
        BigInteger max = field.size();
        if (max.mod(min).equals(BigInteger.ZERO)) {
            throw new IllegalStateException("Cannot invert value: " + value);
        }

        BigInteger[] tail = { BigInteger.ZERO, BigInteger.ONE };

        while (!max.mod(min).equals(BigInteger.ZERO)) {
            final BigInteger[] divideAndRemainder = max.divideAndRemainder(min);
            final BigInteger quotient = divideAndRemainder[0];
            final BigInteger remainder = divideAndRemainder[1];

            final BigInteger tmp = tail[0].subtract(quotient.multiply(tail[1]));
            tail[0] = tail[1];
            tail[1] = tmp;

            max = min;
            min = remainder;
        }

        return field.element(tail[1]);
    }

    @Override
    public GaloisElement invert(final GaloisField field, final long value) {
        return invert(field, BigInteger.valueOf(value));
    }
}
