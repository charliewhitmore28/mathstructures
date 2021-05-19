package com.caw.math.group.field.galois.algorithm.pow;

import com.caw.math.group.field.galois.GaloisElement;
import com.caw.math.group.field.galois.GaloisField;

import java.math.BigInteger;

/**
 * An implementation of the square and multiply algorithm to calculate the value of a {@link GaloisElement} raised to
 * some power inside of some {@link GaloisField}. This implementation leverages the fact that we can reduce the number
 * of operations required to calculate a pow by using the binary representation of the exponent.
 *
 * @author cwhitmore
 */

public class SquareAndMultiplyGaloisPow implements GaloisPow {

    /* default */ SquareAndMultiplyGaloisPow() {
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
        if (power.equals(BigInteger.ZERO)) {
            return field.element(BigInteger.ONE);
        }

        GaloisElement multiplier = element;

        for (int i = power.bitLength() - 2; i >= 0; i--) {
            multiplier = field.multiply(multiplier, multiplier);
            if (power.testBit(i)) {
                multiplier = field.multiply(element, multiplier);
            }
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
