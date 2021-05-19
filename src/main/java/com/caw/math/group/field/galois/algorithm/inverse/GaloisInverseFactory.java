package com.caw.math.group.field.galois.algorithm.inverse;

/**
 * A factory class to provide instances of {@link GaloisInverse} implementations.
 *
 * @author cwhitmore
 */

public final class GaloisInverseFactory {

    private GaloisInverseFactory() {
        // disable public instantiation.
    }

    /**
     * Returns a new instance of the default {@link ItohTsujiiGaloisInverse} implementation.
     *
     * @return
     *      A new instance of the default {@link ItohTsujiiGaloisInverse} implementation.
     */

    public static GaloisInverse make() {
        return new ItohTsujiiGaloisInverse();
    }

    /**
     * Returns a {@link GaloisInverse} implementation based on the specified {@code algorithm}.
     *
     * @param algorithm
     *      The algorithm that dictates what {@link GaloisInverse} is used.
     * @return
     *      A new instance of a {@link GaloisInverse} implementation based on the specified {@code algorithm}.
     */

    public static GaloisInverse make(final GaloisInverseAlgorithm algorithm) {
        return switch (algorithm) {
            case EXTENDED_EUCLIDEAN -> new ExtendedEuclideanGaloisInverse();
            case ITOH_TSUJII -> new ItohTsujiiGaloisInverse();
        };
    }
}
