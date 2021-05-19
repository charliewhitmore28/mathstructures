package com.caw.math.algorithm.fibonacci;

/**
 * A factory class to provide instances of {@link Fibonacci} implementations.
 *
 * @author cwhitmore
 */

public final class FibonacciFactory {

    private FibonacciFactory() {
        // disable public instantiation.
    }

    /**
     * Provide a new instance of the default {@link IterativeFibonacci} algorithm.
     *
     * @return
     *      A new instance of the {@link IterativeFibonacci} algorithm.
     */

    public static Fibonacci make() {
        return new IterativeFibonacci();
    }

    /**
     * Provide a {@link Fibonacci} implementation based on the specified {@code algorithm}.
     *
     * @param algorithm
     *      The algorithm that dictates what implementation will be provided.
     * @return
     *      A new instance of a {@link Fibonacci} implementation based on the specified {@code algorithm}.
     */

    public static Fibonacci make(final FibonacciAlgorithm algorithm) {
        return switch (algorithm) {
            case ITERATIVE -> new IterativeFibonacci();
            case RECURSIVE -> new RecursiveFibonacci();
        };
    }
}
