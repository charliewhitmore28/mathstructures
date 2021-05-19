package com.caw.math.group.field.galois;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class GaloisPrimeElementTest {

    @Test
    public void testReducer() {
        // TODO: Implement GaloisReducer somewhere somehow
    }

    @Test
    public void testAddNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(7);
        final GaloisElement augend = new GaloisPrimeElement(field, 2);
        final GaloisElement sum = augend.add(field.getAdditiveNeutralElement());
        Assertions.assertEquals(BigInteger.valueOf(2), sum.value());
    }

    @Test
    public void testAddNoModRequired() {
        final GaloisPrimeField field = new GaloisPrimeField(7);
        final GaloisElement augend = new GaloisPrimeElement(field, 1);
        final GaloisElement addend = new GaloisPrimeElement(field, 5);
        final GaloisElement sum = augend.add(addend);
        Assertions.assertEquals(BigInteger.valueOf(6), sum.value());
    }

    @Test
    public void testAdd() {
        // 6 + 6 (mod 7) = 12 (mod 7) = 5
        final GaloisPrimeField field = new GaloisPrimeField(7);
        final GaloisElement augend = new GaloisPrimeElement(field, 6);
        final GaloisElement addend = new GaloisPrimeElement(field, 6);
        final GaloisElement sum = augend.add(addend);
        Assertions.assertEquals(BigInteger.valueOf(5), sum.value());
    }

    @Test
    public void testAddBigInteger() {
        final GaloisPrimeField field = new GaloisPrimeField(7);
        final GaloisElement augend = new GaloisPrimeElement(field, 6);
        final GaloisElement sum = augend.add(BigInteger.valueOf(6));
        Assertions.assertEquals(BigInteger.valueOf(5), sum.value());
    }

    @Test
    public void testAddLong() {
        final GaloisPrimeField field = new GaloisPrimeField(7);
        final GaloisElement augend = new GaloisPrimeElement(field, 6);
        final GaloisElement sum = augend.add(6);
        Assertions.assertEquals(BigInteger.valueOf(5), sum.value());
    }

    @Test
    public void testAdditiveInverseNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(11);
        final GaloisElement element = field.getAdditiveNeutralElement();
        final GaloisElement inverse = element.additiveInverse();
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testAdditiveInverse() {
        // 1 + 10 (mod 11) = 11 (mod 11) = 0
        final GaloisPrimeField field = new GaloisPrimeField(11);
        final GaloisElement element = new GaloisPrimeElement(field, 1);
        final GaloisElement inverse = element.additiveInverse();
        Assertions.assertEquals(BigInteger.valueOf(10), inverse.value());
    }

    @Test
    public void testDivideNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement dividend = new GaloisPrimeElement(field, 4);
        final GaloisElement divisor = field.getMultiplicativeNeutralElement();
        final GaloisElement quotient = dividend.divide(divisor);
        Assertions.assertEquals(BigInteger.valueOf(4), quotient.value());
    }

    @Test
    public void testDivide() {
        // Inverse of 3 = 9; 3 * x = 1 (mod 13) => 3 * 9 (mod 13) = 27 (mod 13) = 1
        // 9 * 9 (mod 13) = 81 (mod 13) = 3
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement dividend = new GaloisPrimeElement(field, 9);
        final GaloisElement divisor = new GaloisPrimeElement(field, 3);
        final GaloisElement quotient = dividend.divide(divisor);
        Assertions.assertEquals(BigInteger.valueOf(3), quotient.value());
    }

    @Test
    public void testDivideBigInteger() {
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement dividend = new GaloisPrimeElement(field, 9);
        final GaloisElement quotient = dividend.divide(BigInteger.valueOf(3));
        Assertions.assertEquals(BigInteger.valueOf(3), quotient.value());
    }

    @Test
    public void testDivideLong() {
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement dividend = new GaloisPrimeElement(field, 9);
        final GaloisElement quotient = dividend.divide(3);
        Assertions.assertEquals(BigInteger.valueOf(3), quotient.value());
    }

    @Test
    public void testMultiplicativeInverseNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(17);
        final GaloisElement element = field.getMultiplicativeNeutralElement();
        final GaloisElement inverse = element.multiplicativeInverse();
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testMultiplicativeInverse() {
        // 6 * x = 1 (mod 17) => 6 * 3 (mod 17) = 18 (mod 17) = 1
        final GaloisPrimeField field = new GaloisPrimeField(17);
        final GaloisElement element = new GaloisPrimeElement(field, 6);
        final GaloisElement inverse = element.multiplicativeInverse();
        Assertions.assertEquals(BigInteger.valueOf(3), inverse.value());
    }

    @Test
    public void testMultiplyNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(19);
        final GaloisElement multiplicand = new GaloisPrimeElement(field, 12);
        final GaloisElement multiplier = field.getMultiplicativeNeutralElement();
        final GaloisElement product = multiplicand.multiply(multiplier);
        Assertions.assertEquals(BigInteger.valueOf(12), product.value());
    }

    @Test
    public void testMultiply() {
        // 16 * 7 (mod 19) = 112 (mod 19) = 17
        final GaloisPrimeField field = new GaloisPrimeField(19);
        final GaloisElement multiplicand = new GaloisPrimeElement(field, 16);
        final GaloisElement multiplier = new GaloisPrimeElement(field, 7);
        final GaloisElement product = multiplicand.multiply(multiplier);
        Assertions.assertEquals(BigInteger.valueOf(17), product.value());
    }

    @Test
    public void testMultiplyBigInteger() {
        final GaloisPrimeField field = new GaloisPrimeField(19);
        final GaloisElement multiplicand = new GaloisPrimeElement(field, 16);
        final GaloisElement product = multiplicand.multiply(BigInteger.valueOf(7));
        Assertions.assertEquals(BigInteger.valueOf(17), product.value());
    }

    @Test
    public void testMultiplyLong() {
        final GaloisPrimeField field = new GaloisPrimeField(19);
        final GaloisElement multiplicand = new GaloisPrimeElement(field, 16);
        final GaloisElement product = multiplicand.multiply(7);
        Assertions.assertEquals(BigInteger.valueOf(17), product.value());
    }

    @Test
    public void testSubtractNeutralElement() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement minuend = new GaloisPrimeElement(field, 14);
        final GaloisElement subtrahend = field.getAdditiveNeutralElement();
        final GaloisElement difference = minuend.subtract(subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(14), difference.value());
    }

    @Test
    public void testSubtractNoModRequired() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement minuend = new GaloisPrimeElement(field, 14);
        final GaloisElement subtrahend = new GaloisPrimeElement(field, 4);
        final GaloisElement difference = minuend.subtract(subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(10), difference.value());
    }

    @Test
    public void testSubtract() {
        // 14 - 19 (mod 23) = -5 (mod 23) = 18
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement minuend = new GaloisPrimeElement(field, 14);
        final GaloisElement subtrahend = new GaloisPrimeElement(field, 19);
        final GaloisElement difference = minuend.subtract(subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(18), difference.value());
    }

    @Test
    public void testSubtractBigInteger() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement minuend = new GaloisPrimeElement(field, 14);
        final GaloisElement difference = minuend.subtract(BigInteger.valueOf(19));
        Assertions.assertEquals(BigInteger.valueOf(18), difference.value());
    }

    @Test
    public void testSubtractLong() {
        final GaloisPrimeField field = new GaloisPrimeField(23);
        final GaloisElement minuend = new GaloisPrimeElement(field, 14);
        final GaloisElement difference = minuend.subtract(19);
        Assertions.assertEquals(BigInteger.valueOf(18), difference.value());
    }
}
