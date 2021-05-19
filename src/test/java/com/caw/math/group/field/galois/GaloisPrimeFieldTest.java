package com.caw.math.group.field.galois;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * A test class for {@link GaloisPrimeField}.
 *
 * @author cwhitmore
 */

public class GaloisPrimeFieldTest {

    @Test
    public void testConstructorNonPrimePrime() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new GaloisPrimeField(8));
    }

    @Test
    public void testAddNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(7);
        final GaloisElement augend = new GaloisPrimeElement(field, 4);
        final GaloisElement addend = field.getAdditiveNeutralElement();
        final GaloisElement sum = field.add(augend, addend);
        Assertions.assertEquals(BigInteger.valueOf(4), sum.value());
    }

    @Test
    public void testAddNoModRequired() {
        final GaloisPrimeField field = new GaloisPrimeField(7);
        final GaloisElement augend = new GaloisPrimeElement(field, 4);
        final GaloisElement addend = new GaloisPrimeElement(field, 2);
        final GaloisElement sum = field.add(augend, addend);
        Assertions.assertEquals(BigInteger.valueOf(6), sum.value());
    }

    @Test
    public void testAdd() {
        // 4 + 5 (mod 7) = 9 (mod 7) = 2
        final GaloisPrimeField field = new GaloisPrimeField(7);
        final GaloisElement augend = new GaloisPrimeElement(field, 4);
        final GaloisElement addend = new GaloisPrimeElement(field, 5);
        final GaloisElement sum = field.add(augend, addend);
        Assertions.assertEquals(BigInteger.TWO, sum.value());
    }

    @Test
    public void testAddBigIntegers() {
        final GaloisPrimeField field = new GaloisPrimeField(7);
        final GaloisElement sum = field.add(BigInteger.valueOf(4), BigInteger.valueOf(5));
        Assertions.assertEquals(BigInteger.TWO, sum.value());
    }

    @Test
    public void testAddLongs() {
        final GaloisPrimeField field = new GaloisPrimeField(7);
        final GaloisElement sum = field.add(5, 4);
        Assertions.assertEquals(BigInteger.TWO, sum.value());
    }

    @Test
    public void testAdditiveInverseOfNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(11);
        final GaloisElement element = field.getAdditiveNeutralElement();
        final GaloisElement inverse = field.additiveInverseOf(element);
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testAdditiveInverse() {
        // 8 + 3 (mod 11) = 11 (mod 11) = 0
        final GaloisPrimeField field = new GaloisPrimeField(11);
        final GaloisElement element = new GaloisPrimeElement(field, 8);
        final GaloisElement inverse = field.additiveInverseOf(element);
        Assertions.assertEquals(BigInteger.valueOf(3), inverse.value());
    }

    @Test
    public void testAdditiveInverseBigInteger() {
        final GaloisPrimeField field = new GaloisPrimeField(11);
        final GaloisElement inverse = field.additiveInverseOf(BigInteger.valueOf(8));
        Assertions.assertEquals(BigInteger.valueOf(3), inverse.value());
    }

    @Test
    public void testAdditiveInverseLong() {
        final GaloisPrimeField field = new GaloisPrimeField(11);
        final GaloisElement inverse = field.additiveInverseOf(3);
        Assertions.assertEquals(BigInteger.valueOf(8), inverse.value());
    }

    @Test
    public void testDivideNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement dividend = new GaloisPrimeElement(field, 7);
        final GaloisElement divisor = field.getMultiplicativeNeutralElement();
        final GaloisElement quotient = field.divide(dividend, divisor);
        Assertions.assertEquals(BigInteger.valueOf(7), quotient.value());
    }

    @Test
    public void testDivide() {
        // Inverse of 4 = 10; 10 * 4 (mod 13) = 40 (mod 13) = 1
        // 7 * 10 (mod 13) = 70 (mod 13) = 5
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement dividend = new GaloisPrimeElement(field, 7);
        final GaloisElement divisor = new GaloisPrimeElement(field, 4);
        final GaloisElement quotient = field.divide(dividend, divisor);
        Assertions.assertEquals(BigInteger.valueOf(5), quotient.value());
    }

    @Test
    public void testDivideBigIntegers() {
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement quotient = field.divide(BigInteger.valueOf(7), BigInteger.valueOf(4));
        Assertions.assertEquals(BigInteger.valueOf(5), quotient.value());
    }

    @Test
    public void testDivideLongs() {
        // Inverse of 7 = 2; 7 * 2 (mod 13) = 14 (mod 13) = 1
        // 4 * 2 (mod 13) = 8 (mod 13) = 8
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement quotient = field.divide(4, 7);
        Assertions.assertEquals(BigInteger.valueOf(8), quotient.value());
    }

    @Test
    public void testMultiplicativeInverseOfNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(17);
        final GaloisElement element = field.getMultiplicativeNeutralElement();
        final GaloisElement inverse = field.multiplicativeInverseOf(element);
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testMultiplicativeInverse() {
        // 8 * 15 (mod 17) = 120 (mod 17) = 1
        final GaloisPrimeField field = new GaloisPrimeField(17);
        final GaloisElement element = new GaloisPrimeElement(field, 8);
        final GaloisElement inverse = field.multiplicativeInverseOf(element);
        Assertions.assertEquals(BigInteger.valueOf(15), inverse.value());
    }

    @Test
    public void testMultiplicativeInverseBigInteger() {
        final GaloisPrimeField field = new GaloisPrimeField(17);
        final GaloisElement inverse = field.multiplicativeInverseOf(BigInteger.valueOf(8));
        Assertions.assertEquals(BigInteger.valueOf(15), inverse.value());
    }

    @Test
    public void testMultiplicativeInverseLong() {
        final GaloisPrimeField field = new GaloisPrimeField(17);
        final GaloisElement inverse = field.multiplicativeInverseOf(15);
        Assertions.assertEquals(BigInteger.valueOf(8), inverse.value());
    }

    @Test
    public void testMultiplyNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(19);
        final GaloisElement multiplicand = new GaloisPrimeElement(field, 6);
        final GaloisElement multiplier = field.getMultiplicativeNeutralElement();
        final GaloisElement product = field.multiply(multiplicand, multiplier);
        Assertions.assertEquals(BigInteger.valueOf(6), product.value());
    }

    @Test
    public void testMultiply() {
        // 6 * 12 (mod 19) = 72 (mod 19) = 15
        final GaloisPrimeField field = new GaloisPrimeField(19);
        final GaloisElement multiplicand = new GaloisPrimeElement(field, 6);
        final GaloisElement multiplier = new GaloisPrimeElement(field, 12);
        final GaloisElement product = field.multiply(multiplicand, multiplier);
        Assertions.assertEquals(BigInteger.valueOf(15), product.value());
    }

    @Test
    public void testMultiplyBigIntegers() {
        final GaloisPrimeField field = new GaloisPrimeField(19);
        final GaloisElement product = field.multiply(BigInteger.valueOf(6), BigInteger.valueOf(12));
        Assertions.assertEquals(BigInteger.valueOf(15), product.value());
    }

    @Test
    public void testMultiplyLongs() {
        final GaloisPrimeField field = new GaloisPrimeField(19);
        final GaloisElement product = field.multiply(12, 6);
        Assertions.assertEquals(BigInteger.valueOf(15), product.value());
    }

    @Test
    public void testSubtractNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement minuend = new GaloisPrimeElement(field, 18);
        final GaloisElement subtrahend = field.getAdditiveNeutralElement();
        final GaloisElement difference = field.subtract(minuend, subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(18), difference.value());
    }

    @Test
    public void testSubtractNoModRequired() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement minuend = new GaloisPrimeElement(field, 18);
        final GaloisElement subtrahend = new GaloisPrimeElement(field, 9);
        final GaloisElement difference = field.subtract(minuend, subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(9), difference.value());
    }

    @Test
    public void testSubtract() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement minuend = new GaloisPrimeElement(field, 18);
        final GaloisElement subtrahend = new GaloisPrimeElement(field, 20);
        final GaloisElement difference = field.subtract(minuend, subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(21), difference.value());
    }

    @Test
    public void testSubtractBigIntegers() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement difference = field.subtract(BigInteger.valueOf(18), BigInteger.valueOf(20));
        Assertions.assertEquals(BigInteger.valueOf(21), difference.value());
    }

    @Test
    public void testSubtractLongs() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement difference = field.subtract(18, 20);
        Assertions.assertEquals(BigInteger.valueOf(21), difference.value());
    }
}
