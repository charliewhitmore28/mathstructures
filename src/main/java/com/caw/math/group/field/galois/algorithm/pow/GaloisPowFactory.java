package com.caw.math.group.field.galois.algorithm.pow;

/**
 * A factory class to provides {@link GaloisPow} implementations.
 *
 * @author cwhitmore
 */

public final class GaloisPowFactory {

    private GaloisPowFactory() {
        // disable public instantiation.
    }

    /**
     * Returns a new instance of the default {@link SquareAndMultiplyGaloisPow} implementation.
     *
     * @return
     *      A new instance of the default {@link SquareAndMultiplyGaloisPow} implementation.
     */

    public static GaloisPow make() {
        return new SquareAndMultiplyGaloisPow();
    }

    /**
     * Returns a {@link GaloisPow} implementation based on the specified {@code algorithm}.
     *
     * @param algorithm
     *      The algorithm that dictates what implementation is used.
     * @return
     *      A new instance of a {@link GaloisPow} implementation based on the specified {@code algorithm}.
     */

    public static GaloisPow make(final GaloisPowAlgorithm algorithm) {
        return switch (algorithm) {
            case BRUTE_FORCE -> new BruteForceGaloisPow();
            case SQUARE_AND_MULTIPLY -> new SquareAndMultiplyGaloisPow();
        };
    }
}
