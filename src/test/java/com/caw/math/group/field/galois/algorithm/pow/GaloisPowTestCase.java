package com.caw.math.group.field.galois.algorithm.pow;

import com.caw.math.group.field.galois.GaloisElement;
import com.caw.math.group.field.galois.GaloisPrimeElement;
import com.caw.math.group.field.galois.GaloisPrimeField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public abstract class GaloisPowTestCase {

    private GaloisPow pow;

    @BeforeEach
    public void setUp() {
        pow = makeGaloisPow();
    }

    @Test
    public void testZeroPowPrime() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement element = field.element(BigInteger.ZERO);
        final GaloisElement actual = pow.pow(element, 8);
        Assertions.assertEquals(BigInteger.ZERO, actual.value());
    }

    @Test
    public void testPowZeroPrime() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement element = field.element(8);
        final GaloisElement actual = pow.pow(element, 0);
        Assertions.assertEquals(BigInteger.ONE, actual.value());
    }

    @Test
    public void testPowOnePrime() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement element = field.element(8);
        final GaloisElement actual = pow.pow(element, 1);
        Assertions.assertEquals(BigInteger.valueOf(8), actual.value());
    }

    @Test
    public void testPowPrime() {
        // 8 ^ 5 (mod 23) = 8 * 8 * 8 * 8 * 8 (mod 23) = 64 * 64 * 8 (mod 23) = 18 * 18 * 8 (mod 23)
        // = 324 * 8 (mod 23) = 2 * 8 (mod 23) = 16
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement element = field.element(8);
        final GaloisElement actual = pow.pow(element, 5);
        Assertions.assertEquals(BigInteger.valueOf(16), actual.value());
    }

    @Test
    public void testPowBigIntegerPrime() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement actual = pow.pow(field, BigInteger.valueOf(8), BigInteger.valueOf(5));
        Assertions.assertEquals(BigInteger.valueOf(16), actual.value());
    }

    @Test
    public void testPowLongPrime() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement actual = pow.pow(field, 8, 5);
        Assertions.assertEquals(BigInteger.valueOf(16), actual.value());
    }

    @Test
    public void testPowIllegalPowerPrime() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement element = field.element(8);
        Assertions.assertThrows(IllegalArgumentException.class, () -> pow.pow(element, -1));
    }

    @Test
    public void testPowIllegalBigIntegerPrime() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> pow.pow(field, BigInteger.valueOf(-1), BigInteger.valueOf(5)));
    }

    @Test
    public void testPowIllegalLongPrime() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> pow.pow(field, -2, 5));
    }

    @Test
    public void testPowStressPrime() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement element = field.element(8);
        final GaloisElement actual = pow.pow(element, 1_234_567);
        Assertions.assertEquals(BigInteger.TWO, actual.value());
    }


    /**
     * Make a {@link GaloisPow} implementation to test.
     */

    protected abstract GaloisPow makeGaloisPow();
}
