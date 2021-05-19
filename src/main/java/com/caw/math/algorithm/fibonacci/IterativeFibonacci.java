package com.caw.math.algorithm.fibonacci;

import java.math.BigInteger;

/**
 * An implementation of {@link Fibonacci} that uses an iterative approach to calculate the fibonacci number.
 *
 * @author cwhitmore
 */

public class IterativeFibonacci implements Fibonacci {

    /* default */ IterativeFibonacci() {
        // disable non-default instantiation
    }

    @Override
    public BigInteger calculate(final BigInteger nthElement) {

        if (nthElement.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Illegal parameter: n=" + nthElement);
        }

        if (nthElement.equals(BigInteger.ZERO) || nthElement.equals(BigInteger.ONE)) {
            return nthElement;
        }

        final BigInteger[] tail = { BigInteger.ZERO, BigInteger.ONE };

        for (BigInteger i = BigInteger.TWO; i.compareTo(nthElement) <= 0; i = i.add(BigInteger.ONE)) {
            final BigInteger head = tail[0].add(tail[1]);
            tail[0] = tail[1];
            tail[1] = head;
        }

        return tail[1];
    }

    @Override
    public BigInteger calculate(final long nthElement) {
        return calculate(BigInteger.valueOf(nthElement));
    }
}
