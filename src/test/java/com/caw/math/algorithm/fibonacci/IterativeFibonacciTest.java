package com.caw.math.algorithm.fibonacci;

/**
 * An extension of {@link FibonacciTestCase} that tests the {@link IterativeFibonacci} algorithm.
 *
 * @author cwhitmore
 */

public class IterativeFibonacciTest extends FibonacciTestCase {

    @Override
    public Fibonacci makeFibonacci() {
        return new IterativeFibonacci();
    }
}
