package com.caw.math.group.ring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * A test class for {@link IntegerRing}.
 *
 * @author cwhitmore
 */

public class IntegerRingTest {

    @Test
    public void testAddNeutralElement() {
        final IntegerRing ring = new IntegerRing(12);
        final IntegerRingElement augend = new IntegerRingElement(ring, 7);
        final IntegerRingElement addend = ring.getAdditiveNeutralElement();
        final IntegerRingElement sum = ring.add(augend, addend);
        Assertions.assertEquals(BigInteger.valueOf(7), sum.value());
    }

    @Test
    public void testAddDoesNotExceedSize() {
        final IntegerRing ring = new IntegerRing(12);
        final IntegerRingElement augend = new IntegerRingElement(ring, 7);
        final IntegerRingElement addend = new IntegerRingElement(ring, 4);
        final IntegerRingElement sum = ring.add(augend, addend);
        Assertions.assertEquals(BigInteger.valueOf(11), sum.value());
    }

    @Test
    public void testAddExceedsSize() {
        // 7 + 8 (mod 12) = 15 (mod 12) = 3
        final IntegerRing ring = new IntegerRing(12);
        final IntegerRingElement augend = new IntegerRingElement(ring, 7);
        final IntegerRingElement addend = new IntegerRingElement(ring, 8);
        final IntegerRingElement sum = ring.add(augend, addend);
        Assertions.assertEquals(BigInteger.valueOf(3), sum.value());
    }

    @Test
    public void testAddBigIntegers() {
        final IntegerRing ring = new IntegerRing(12);
        final IntegerRingElement sum = ring.add(BigInteger.valueOf(7), BigInteger.valueOf(8));
        Assertions.assertEquals(BigInteger.valueOf(3), sum.value());
    }

    @Test
    public void testAddLongs() {
        final IntegerRing ring = new IntegerRing(12);
        final IntegerRingElement sum = ring.add(7, 8);
        Assertions.assertEquals(BigInteger.valueOf(3), sum.value());
    }

    @Test
    public void testAdditiveInverseNeutralElement() {
        final IntegerRing ring = new IntegerRing(28);
        final IntegerRingElement neutral = ring.getAdditiveNeutralElement();
        final IntegerRingElement inverse = ring.additiveInverseOf(neutral);
        Assertions.assertEquals(neutral.value(), inverse.value());
    }

    @Test
    public void testAdditiveInverse() {
        // 19 + 9 (mod 28) = 28 (mod 28) = 0
        final IntegerRing ring = new IntegerRing(28);
        final IntegerRingElement element = new IntegerRingElement(ring, 19);
        final IntegerRingElement inverse = ring.additiveInverseOf(element);
        Assertions.assertEquals(BigInteger.valueOf(9), inverse.value());
    }

    @Test
    public void testAdditiveInverseBigInteger() {
        final IntegerRing ring = new IntegerRing(28);
        final IntegerRingElement inverse = ring.additiveInverseOf(BigInteger.valueOf(19));
        Assertions.assertEquals(BigInteger.valueOf(9), inverse.value());
    }

    @Test
    public void testAdditiveInverseLong() {
        final IntegerRing ring = new IntegerRing(28);
        final IntegerRingElement inverse = ring.additiveInverseOf(19);
        Assertions.assertEquals(BigInteger.valueOf(9), inverse.value());
    }

    @Test
    public void testConstructorExceedsRingSize() {
        final IntegerRing ring = new IntegerRing(4);
        final IntegerRingElement element = new IntegerRingElement(ring, 7);
        Assertions.assertEquals(BigInteger.valueOf(3), element.value());
    }

    @Test
    public void testBigIntegerConstructorExceedsRingSize() {
        final IntegerRing ring = new IntegerRing(4);
        final IntegerRingElement element = new IntegerRingElement(ring, BigInteger.valueOf(7));
        Assertions.assertEquals(BigInteger.valueOf(3), element.value());
    }

    @Test
    public void testGetAdditiveNeutralElement() {
        final IntegerRing ring = new IntegerRing(12);
        final IntegerRingElement additiveNeutralElement = ring.getAdditiveNeutralElement();
        Assertions.assertEquals(BigInteger.ZERO, additiveNeutralElement.value());
    }

    @Test
    public void testSubtractNeutralElement() {
        final IntegerRing ring = new IntegerRing(100);
        final IntegerRingElement minuend = new IntegerRingElement(ring, 50);
        final IntegerRingElement subtrahend = ring.getAdditiveNeutralElement();
        final IntegerRingElement difference = ring.subtract(minuend, subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(50), difference.value());
    }

    @Test
    public void testSubtractNegativeOutcome() {
        // 50 - 67 (mod 100) = -17 (mod 100) = 83
        final IntegerRing ring = new IntegerRing(100);
        final IntegerRingElement minuend = new IntegerRingElement(ring, 50);
        final IntegerRingElement subtrahend = new IntegerRingElement(ring, 67);
        final IntegerRingElement difference = ring.subtract(minuend, subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(83), difference.value());
    }

    @Test
    public void testSubtract() {
        final IntegerRing ring = new IntegerRing(100);
        final IntegerRingElement minuend = new IntegerRingElement(ring, 50);
        final IntegerRingElement subtrahend = new IntegerRingElement(ring, 33);
        final IntegerRingElement difference = ring.subtract(minuend, subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(17), difference.value());
    }

    @Test
    public void testSubtractBigIntegers() {
        final IntegerRing ring = new IntegerRing(100);
        final IntegerRingElement difference = ring.subtract(BigInteger.valueOf(50), BigInteger.valueOf(33));
        Assertions.assertEquals(BigInteger.valueOf(17), difference.value());
    }

    @Test
    public void testSubtractLongs() {
        final IntegerRing ring = new IntegerRing(100);
        final IntegerRingElement difference = ring.subtract(50, 33);
        Assertions.assertEquals(BigInteger.valueOf(17), difference.value());
    }

}
