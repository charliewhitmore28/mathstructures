package com.caw.math.algorithm.gcd;

import java.math.BigInteger;

/**
 * An implementation of {@link GCD} which uses brute force to calculate the greatest common divisor.
 *
 * @author cwhitmore
 */

public class BruteForceGCD implements GCD {

    /* default */ BruteForceGCD() {
        // disable non-default instantiation.
    }

    @Override
    public BigInteger calculate(final BigInteger dividend1, final BigInteger dividend2) {

        if (dividend1.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("Illegal parameter: dividend1=" + dividend1);
        }
        if (dividend2.compareTo(BigInteger.ONE) <= 0) {
            throw new IllegalArgumentException("Illegal parameter: dividend2=" + dividend2);
        }

        BigInteger ceiling = dividend1.max(dividend2).divide(BigInteger.TWO);
        while (ceiling.compareTo(BigInteger.ZERO) > 0) {
            if (dividend1.mod(ceiling).equals(BigInteger.ZERO) && dividend2.mod(ceiling).equals(BigInteger.ZERO)) {
                return ceiling;
            }
            ceiling = ceiling.subtract(BigInteger.ONE);
        }

        throw new IllegalStateException(getClass().getSimpleName() + " failed to converge: dividend1=" + dividend1 + ", dividend2=" + dividend2);
    }

    @Override
    public BigInteger calculate(final long dividend1, final long dividend2) {

        return calculate(BigInteger.valueOf(dividend1), BigInteger.valueOf(dividend2));
    }
}
