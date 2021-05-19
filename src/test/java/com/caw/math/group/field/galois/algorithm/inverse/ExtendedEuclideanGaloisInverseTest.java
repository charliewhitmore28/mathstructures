package com.caw.math.group.field.galois.algorithm.inverse;

/**
 * A test class for {@link ExtendedEuclideanGaloisInverse}.
 *
 * @author cwhitmore
 */

public class ExtendedEuclideanGaloisInverseTest extends GaloisInverseTestCase {

    @Override
    public GaloisInverse makeGaloisInverse() {
        return new ExtendedEuclideanGaloisInverse();
    }
}
