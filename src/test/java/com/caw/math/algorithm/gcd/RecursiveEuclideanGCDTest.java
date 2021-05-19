package com.caw.math.algorithm.gcd;

/**
 * An extension of {@link GCDTestCase} which tests the {@link RecursiveEuclideanGCD} algorithm.
 *
 * @author cwhitmore
 */

public class RecursiveEuclideanGCDTest extends GCDTestCase {

    @Override
    public GCD makeGCD() {
        return new RecursiveEuclideanGCD();
    }
}
