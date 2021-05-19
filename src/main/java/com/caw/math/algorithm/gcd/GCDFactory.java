package com.caw.math.algorithm.gcd;

/**
 * A factory class to provide implementations of {@link GCD}.
 *
 * @author cwhitmore
 */

public final class GCDFactory {

    private GCDFactory() {
        // disable public instantiation
    }

    /**
     * Provides a new instance of the default {@link IterativeEuclideanGCD} implementation.
     *
     * @return
     *      A new instance of the default {@link IterativeEuclideanGCD} implementation.
     */

    public static GCD make() {
        return new IterativeEuclideanGCD();
    }

    /**
     * Provides a new instance of a {@link GCD} implementation based on the specified {@code algorithm}.
     *
     * @param algorithm
     *      The algorithm that dictates what implementation will be provided.
     * @return
     *      A new instance of a {@link GCD} implementation based on the specified {@code algorithm}.
     */

    public static GCD make(final GCDAlgorithm algorithm) {
        return switch (algorithm) {
            case BRUTE_FORCE -> new BruteForceGCD();
            case ITERATIVE_EUCLIDIAN -> new IterativeEuclideanGCD();
            case RECURSIVE_EUCLIDIAN -> new RecursiveEuclideanGCD();
        };
    }
}
