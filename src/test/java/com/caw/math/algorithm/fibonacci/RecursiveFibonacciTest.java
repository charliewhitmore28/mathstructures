package com.caw.math.algorithm.fibonacci;

import org.junit.jupiter.api.Test;

/**
 * An extension of {@link FibonacciTestCase} which tests the {@link RecursiveFibonacci} algorithm.
 *
 * @author cwhitmore
 */

public class RecursiveFibonacciTest extends FibonacciTestCase {

    @Override
    public Fibonacci makeFibonacci() {
        return new RecursiveFibonacci();
    }

    @Override
    @Test
    public void testFibonacciStress() {
        // Do nothing. Recursive algorithm not suited for high stress.
    }
}
