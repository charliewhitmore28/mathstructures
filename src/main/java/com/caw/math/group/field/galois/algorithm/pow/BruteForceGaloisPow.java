package com.caw.math.group.field.galois.algorithm.pow;

import com.caw.math.group.field.galois.GaloisElement;
import com.caw.math.group.field.galois.GaloisField;

import java.math.BigInteger;

/**
 * An implementation of {@link GaloisPow} that uses brute force to calculate a {@link GaloisElement} raised to some
 * power inside of a {@link GaloisField}.
 *
 * @author cwhitmore
 */

public class BruteForceGaloisPow implements GaloisPow {

    /* default */ BruteForceGaloisPow() {
        // disable non-default instantiation.
    }

    @Override
    public GaloisElement pow(final GaloisElement element, final BigInteger power) {

        if (power.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Illegal parameter: power=" + power);
        }

        final GaloisField field = element.field();
        if (element.value().equals(BigInteger.ZERO)) {
            return field.element(BigInteger.ZERO);
        }

        GaloisElement multiplier = field.element(BigInteger.ONE);
        for (BigInteger i = BigInteger.ZERO; i.compareTo(power) < 0; i = i.add(BigInteger.ONE)) {
            multiplier = field.multiply(element, multiplier);
        }
        return multiplier;
    }

    @Override
    public GaloisElement pow(final GaloisElement element, final long power) {

        if (power < 0) {
            throw new IllegalArgumentException("Illegal parameter: power=" + power);
        }
        return pow(element, BigInteger.valueOf(power));
    }

    @Override
    public GaloisElement pow(final GaloisField field, final BigInteger value, final BigInteger power) {

        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Illegal parameter: value=" + value);
        }

        return pow(field.element(value), power);
    }

    @Override
    public GaloisElement pow(final GaloisField field, final long value, final long power) {
        return pow(field, BigInteger.valueOf(value), BigInteger.valueOf(power));
    }
}
