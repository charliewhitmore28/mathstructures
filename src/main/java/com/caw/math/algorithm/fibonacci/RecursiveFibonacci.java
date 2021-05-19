package com.caw.math.algorithm.fibonacci;

import java.math.BigInteger;

/**
 * An implementation of {@link Fibonacci} that uses a recursive approach to calculate the fibonacci number.
 *
 * @author cwhitmore
 */

public class RecursiveFibonacci implements Fibonacci {

    /* default */ RecursiveFibonacci() {
        // disable non-default instantiation.
    }

    @Override
    public BigInteger calculate(final BigInteger nthElement) {

        // Don't perform unnecessary guardrail checks during every recursive call.
        if (nthElement.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Illegal parameter: n=" + nthElement);
        }

        return calculateRecursive(nthElement);
    }

    @Override
    public BigInteger calculate(final long nthElement) {
        return calculate(BigInteger.valueOf(nthElement));
    }

    private BigInteger calculateRecursive(final BigInteger nthElement) {

        if (nthElement.equals(BigInteger.ZERO) || nthElement.equals(BigInteger.ONE)) {
            return nthElement;
        }

        final BigInteger nMinusOne = calculateRecursive(nthElement.subtract(BigInteger.ONE));
        final BigInteger nMinusTwo = calculateRecursive(nthElement.subtract(BigInteger.TWO));

        return nMinusOne.add(nMinusTwo);
    }
}
