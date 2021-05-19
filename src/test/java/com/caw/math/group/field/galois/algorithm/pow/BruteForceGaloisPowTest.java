package com.caw.math.group.field.galois.algorithm.pow;

public class BruteForceGaloisPowTest extends GaloisPowTestCase {

    @Override
    protected GaloisPow makeGaloisPow() {
        return new BruteForceGaloisPow();
    }

    @Override
    public void testPowStressPrime() {
        // Do nothing. Brute force cannot support stress test.
    }
}
