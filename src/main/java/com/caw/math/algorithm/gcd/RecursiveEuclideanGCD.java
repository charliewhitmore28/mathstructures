package com.caw.math.algorithm.gcd;

import java.math.BigInteger;

/**
 * An implementation of {@link GCD} which uses the euclidean algorithm with a recursive approach to calculate the
 * greatest common divisor.
 *
 * @author cwhitmore.
 */

public class RecursiveEuclideanGCD implements GCD {

    /* default */ RecursiveEuclideanGCD() {
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

        return calculateRecursive(dividend1, dividend2);
    }

    @Override
    public BigInteger calculate(final long dividend1, final long dividend2) {
        return calculate(BigInteger.valueOf(dividend1), BigInteger.valueOf(dividend2));
    }

    private BigInteger calculateRecursive(final BigInteger dividend1, final BigInteger dividend2) {

        BigInteger ceiling = dividend1.max(dividend2);
        final BigInteger floor = dividend1.min(dividend2);

        if (ceiling.mod(floor).equals(BigInteger.ZERO)) {
            return floor;
        }

        while (ceiling.compareTo(floor) > 0) {
            ceiling = ceiling.subtract(floor);
        }

        return calculateRecursive(ceiling, floor);
    }
}
