package com.caw.math.algorithm.gcd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * A base test class for testing {@link GCDTestCase} implementations.
 *
 * @author cwhitmore
 */

public abstract class GCDTestCase {

    private GCD gcd;

    @BeforeEach
    public void setUp() {
        gcd = makeGCD();
    }

    @Test
    public void testGCDn1IllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gcd.calculate(BigInteger.valueOf(-1), BigInteger.ONE));
    }

    @Test
    public void testGCDn2IllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gcd.calculate(BigInteger.ONE, BigInteger.valueOf(0)));
    }

    @Test
    public void testGCDOne() {
        // There is no non-one greatest common divisor of two prime numbers.
        final BigInteger actual = gcd.calculate(BigInteger.valueOf(3), BigInteger.valueOf(5));
        Assertions.assertEquals(BigInteger.ONE, actual);
    }

    @Test
    public void testGCD() {
        final BigInteger actual = gcd.calculate(BigInteger.valueOf(64), BigInteger.valueOf(32));
        Assertions.assertEquals(BigInteger.valueOf(32), actual);
    }

    @Test
    public void testGCDLongs() {
        final BigInteger actual = gcd.calculate(64, 32);
        Assertions.assertEquals(BigInteger.valueOf(32), actual);
    }

    @Test
    public void testGCDStress() {
        final BigInteger actual = gcd.calculate(BigInteger.valueOf(655361220), BigInteger.valueOf(1884422880));
        Assertions.assertEquals(BigInteger.valueOf(60), actual);
    }

    /**
     * Make an implementation of the {@link GCD} interface to test.
     */

    public abstract GCD makeGCD();
}
