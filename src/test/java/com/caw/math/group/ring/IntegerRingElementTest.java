package com.caw.math.group.ring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * A test class for {@link IntegerRingElement}.
 *
 * @author cwhitmore
 */

public class IntegerRingElementTest {

    @Test
    public void testAddNeutralElement() {
        final IntegerRing ring = new IntegerRing(12);
        final IntegerRingElement augend = new IntegerRingElement(ring, 7);
        final IntegerRingElement sum = augend.add(ring.getAdditiveNeutralElement());
        Assertions.assertEquals(BigInteger.valueOf(7), sum.value());
    }

    @Test
    public void testAdd() {
        final IntegerRing ring = new IntegerRing(12);
        final IntegerRingElement augend = new IntegerRingElement(ring, 7);
        final IntegerRingElement sum = augend.add(new IntegerRingElement(ring, 4));
        Assertions.assertEquals(BigInteger.valueOf(11), sum.value());
    }

    @Test
    public void testAddExceedsRingSize() {
        final IntegerRing ring = new IntegerRing(12);
        final IntegerRingElement augend = new IntegerRingElement(ring, 7);
        final IntegerRingElement sum = augend.add(new IntegerRingElement(ring, 8));
        Assertions.assertEquals(BigInteger.valueOf(3), sum.value());
    }

    @Test
    public void testAddBigInteger() {
        final IntegerRing ring = new IntegerRing(12);
        final IntegerRingElement augend = new IntegerRingElement(ring, 7);
        final IntegerRingElement sum = augend.add(BigInteger.valueOf(8));
        Assertions.assertEquals(BigInteger.valueOf(3), sum.value());
    }

    @Test
    public void testAddLong() {
        final IntegerRing ring = new IntegerRing(12);
        final IntegerRingElement augend = new IntegerRingElement(ring, 7);
        final IntegerRingElement sum = augend.add(8);
        Assertions.assertEquals(BigInteger.valueOf(3), sum.value());
    }

    @Test
    public void testAdditiveInverseNeutralElement() {
        final IntegerRing ring = new IntegerRing(28);
        final IntegerRingElement neutralElement = ring.getAdditiveNeutralElement();
        final IntegerRingElement inverse = neutralElement.additiveInverse();
        Assertions.assertEquals(neutralElement.value(), inverse.value());
    }

    @Test
    public void testAdditiveInverse() {
        final IntegerRing ring = new IntegerRing(28);
        final IntegerRingElement element = new IntegerRingElement(ring, 19);
        final IntegerRingElement inverse = element.additiveInverse();
        Assertions.assertEquals(BigInteger.valueOf(9), inverse.value());
    }

    @Test
    public void testSubtractNeutralElement() {
        final IntegerRing ring = new IntegerRing(100);
        final IntegerRingElement minuend = new IntegerRingElement(ring, 50);
        final IntegerRingElement difference = minuend.subtract(ring.getAdditiveNeutralElement());
        Assertions.assertEquals(BigInteger.valueOf(50), difference.value());
    }

    @Test
    public void testSubtractNegativeOutcome() {
        final IntegerRing ring = new IntegerRing(100);
        final IntegerRingElement minuend = new IntegerRingElement(ring, 50);
        final IntegerRingElement difference = minuend.subtract(new IntegerRingElement(ring, 67));
        Assertions.assertEquals(BigInteger.valueOf(83), difference.value());
    }

    @Test
    public void testSubtract() {
        final IntegerRing ring = new IntegerRing(100);
        final IntegerRingElement minuend = new IntegerRingElement(ring, 50);
        final IntegerRingElement difference = minuend.subtract(new IntegerRingElement(ring, 33));
        Assertions.assertEquals(BigInteger.valueOf(17), difference.value());
    }

    @Test
    public void testSubtractBigInteger() {
        final IntegerRing ring = new IntegerRing(100);
        final IntegerRingElement minuend = new IntegerRingElement(ring, 50);
        final IntegerRingElement difference = minuend.subtract(BigInteger.valueOf(33));
        Assertions.assertEquals(BigInteger.valueOf(17), difference.value());
    }

    @Test
    public void testSubtractLong() {
        final IntegerRing ring = new IntegerRing(100);
        final IntegerRingElement minuend = new IntegerRingElement(ring, 50);
        final IntegerRingElement difference = minuend.subtract(33);
        Assertions.assertEquals(BigInteger.valueOf(17), difference.value());
    }

}
