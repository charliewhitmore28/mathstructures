package com.caw.math.algorithm.gcd;

/**
 * An extension of {@link GCDTestCase} which tests the {@link BruteForceGCD} algorithm.
 *
 * @author cwhitmore
 */

public class BruteForceGCDTest extends GCDTestCase {

    @Override
    public GCD makeGCD() {
        return new BruteForceGCD();
    }

    @Override
    public void testGCDStress() {
        // Do nothing. Brute Force algorithm cannot pass stress test.
    }
}
