package com.caw.math.algorithm.gcd;

/**
 * An extension of {@link GCDTestCase} which tests the {@link IterativeEuclideanGCD} algorithm.
 *
 * @author cwhitmore
 */

public class IterativeEuclideanGCDTest extends GCDTestCase {

    @Override
    public GCD makeGCD() {
        return new IterativeEuclideanGCD();
    }
}
