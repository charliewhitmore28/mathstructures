package com.caw.math.algorithm.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * A base test class for testing {@link Fibonacci} implementations.
 *
 * @author cwhitmore
 */

public abstract class FibonacciTestCase {

    private Fibonacci fibonacci;

    @BeforeEach
    public void setUp() {
        fibonacci = makeFibonacci();
    }

    @Test
    public void testFibonacciIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> fibonacci.calculate(BigInteger.valueOf(-1)));
    }

    @Test
    public void testFibonacciBaseCaseZero() {
        final BigInteger actual = fibonacci.calculate(BigInteger.ZERO);
        Assertions.assertEquals(BigInteger.ZERO, actual);
    }

    @Test
    public void testFibonacciBaseCaseOne() {
        final BigInteger actual = fibonacci.calculate(BigInteger.ONE);
        Assertions.assertEquals(BigInteger.ONE, actual);
    }

    @Test
    public void testFibonacciFirstNonBaseCase() {
        final BigInteger actual = fibonacci.calculate(BigInteger.TWO);
        Assertions.assertEquals(BigInteger.ONE, actual);
    }

    @Test
    public void testFibonacci() {
        final BigInteger actual = fibonacci.calculate(BigInteger.TEN);
        Assertions.assertEquals(BigInteger.valueOf(55), actual);
    }

    @Test
    public void testFibonacciLong() {
        final BigInteger actual = fibonacci.calculate(10);
        Assertions.assertEquals(BigInteger.valueOf(55), actual);
    }

    @Test
    public void testFibonacciStress() {
        final BigInteger actual = fibonacci.calculate(BigInteger.valueOf(50));
        Assertions.assertEquals(BigInteger.valueOf(12586269025L), actual);
    }


    /**
     * Make an implementation of the {@link Fibonacci} interface to test.
     */

    abstract Fibonacci makeFibonacci();
}
