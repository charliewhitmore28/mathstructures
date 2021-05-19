package com.caw.math.group.field.galois.algorithm.inverse;

public class ItohTsujiiGaloisInverseTest extends GaloisInverseTestCase {

    @Override
    public GaloisInverse makeGaloisInverse() {
        return new ItohTsujiiGaloisInverse();
    }
}
