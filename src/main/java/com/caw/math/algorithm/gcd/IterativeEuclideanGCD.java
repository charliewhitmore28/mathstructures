package com.caw.math.algorithm.gcd;

import java.math.BigInteger;

/**
 * An implementation of {@link GCD} which uses the euclidean algorithm with an iterative approach to calculate the
 * greatest common divisor.
 *
 * @author cwhitmore
 */

public class IterativeEuclideanGCD implements GCD {

    /* default */ IterativeEuclideanGCD() {
        // disable non-default instantiation.
    }

    @Override
    public BigInteger calculate(final BigInteger dividend1, final BigInteger dividend2) {

        if (dividend1.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("Illegal parameter: n1=" + dividend1);
        }
        if (dividend2.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("Illegal parameter: n2=" + dividend2);
        }

        BigInteger ceiling = dividend1.max(dividend2);
        BigInteger floor = dividend1.min(dividend2);

        while (!ceiling.mod(floor).equals(BigInteger.ZERO)) {

            while (ceiling.compareTo(floor) > 0) {
                ceiling = ceiling.subtract(floor);
            }
            final BigInteger swap = ceiling;
            ceiling = floor;
            floor = swap;
        }

        return floor;
    }

    @Override
    public BigInteger calculate(final long dividend1, final long dividend2) {
        return calculate(BigInteger.valueOf(dividend1), BigInteger.valueOf(dividend2));
    }
}
