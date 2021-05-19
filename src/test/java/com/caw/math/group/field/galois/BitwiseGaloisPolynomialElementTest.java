package com.caw.math.group.field.galois;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * Test class for {@link GaloisPolynomialElement} inside a {@link GaloisPolynomialField} with a supplied {@code prime}
 * of two.
 *
 * @author cwhitmore
 */

public class BitwiseGaloisPolynomialElementTest {

    // Let's test the same mathematical operations with this test class that we do with BitwiseGaloisPolynomialFieldTest
    // but with a different irreducible polynomial, ensuring field behavior across the different irreducibles.
    // 285 = x^8 + x^4 + x^3 + x^2 + 1

    @Test
    public void testAddNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement augend = new GaloisPolynomialElement(field, 49);
        final GaloisElement addend = field.getAdditiveNeutralElement();
        final GaloisElement sum = augend.add(addend);
        Assertions.assertEquals(BigInteger.valueOf(49), sum.value());
    }

    @Test
    public void testAddNoModRequired() {
        // 110001 + 110 = 110111 = 32 + 16 + 4 + 2 + 1 = 55
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement augend = new GaloisPolynomialElement(field, 49);
        final GaloisElement addend = new GaloisPolynomialElement(field, 6);
        final GaloisElement sum = augend.add(addend);
        Assertions.assertEquals(BigInteger.valueOf(55), sum.value());
    }

    @Test
    public void testAdd() {
        // 11110000 + 101100 = 11011100 = 128 + 64 + 16 + 8 + 4 = 220
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement augend = new GaloisPolynomialElement(field, 49);
        final GaloisElement addend = new GaloisPolynomialElement(field, 40);
        final GaloisElement sum = augend.add(addend);
        Assertions.assertEquals(BigInteger.valueOf(25), sum.value());
    }

    @Test
    public void testAddBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement augend = new GaloisPolynomialElement(field, 49);
        final GaloisElement sum = augend.add(BigInteger.valueOf(40));
        Assertions.assertEquals(BigInteger.valueOf(25), sum.value());
    }

    @Test
    public void testAddLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement augend = new GaloisPolynomialElement(field, 49);
        final GaloisElement sum = augend.add(40);
        Assertions.assertEquals(BigInteger.valueOf(25), sum.value());
    }

    @Test
    public void testAdditiveInverseNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement element = field.getAdditiveNeutralElement();
        final GaloisElement inverse = element.additiveInverse();
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testAdditiveInverse() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement element = new GaloisPolynomialElement(field, 85);
        final GaloisElement inverse = element.additiveInverse();
        Assertions.assertEquals(BigInteger.valueOf(85), inverse.value());
    }

    @Test
    public void testDivideNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 30);
        final GaloisElement divisor = field.getMultiplicativeNeutralElement();
        final GaloisElement quotient = dividend.divide(divisor);
        Assertions.assertEquals(BigInteger.valueOf(30), quotient.value());
    }

    @Test
    public void testDivide() {
        // Inverse of 12 = 1100 * x (mod x^8 + x^4 + x^3 + x + 1) = 1?
        // 1100 * 111101 (61) = 110000000 + 11000000 + 1100000 + 110000 + 1100
        // 100011100 = 1
        // 100011101
        // 40 * 61 = 101000 * 111101 = 10100000000 + 1010000000 + 101000000 + 10100000 + 101000 = 11001001000 -> reduce
        // 11001001000 = 1000111100 = 110 = 6
        // 100011101<-   100011101<
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 40);
        final GaloisElement divisor = new GaloisPolynomialElement(field, 12);
        final GaloisElement quotient = dividend.divide(divisor);
        Assertions.assertEquals(BigInteger.valueOf(6), quotient.value());
    }

    @Test
    public void testDivideBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 40);
        final GaloisElement quotient = dividend.divide(BigInteger.valueOf(12));
        Assertions.assertEquals(BigInteger.valueOf(6), quotient.value());
    }

    @Test
    public void testDivideLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 40);
        final GaloisElement quotient = dividend.divide(12);
        Assertions.assertEquals(BigInteger.valueOf(6), quotient.value());
    }

    @Test
    public void testMultiplicativeInverseNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement element = field.getMultiplicativeNeutralElement();
        final GaloisElement inverse = element.multiplicativeInverse();
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testMultiplicativeInverse() {
        // 101 = (1100101 * x) / (mod x^8 + x^4 + x^3 + x + 1) = 1?
        // 1100101 * 11000100 = 11001010000000 + 1100101000000 + 110010100 = 10101001010100
        // 10101001010100 = 100111110100 = 100011100 = 1
        // 100011101<----   100011101<--   100011101
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement element = new GaloisPolynomialElement(field, 101);
        final GaloisElement inverse = element.multiplicativeInverse();
        Assertions.assertEquals(BigInteger.valueOf(196), inverse.value());
    }

    @Test
    public void testMultiply() {
        // 75 * 34 = 1001011 * 0100010 = 100101100000 + 10010110 = 100111110110 -> reduce
        // 100111110110 = 100011110 = 11 = 2 + 1 = 3
        // 100011101<--   100011101
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 75);
        final GaloisElement multiplier = new GaloisPolynomialElement(field, 34);
        final GaloisElement product = multiplicand.multiply(multiplier);
        Assertions.assertEquals(BigInteger.valueOf(3), product.value());
    }

    @Test
    public void testMultiplyBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 75);
        final GaloisElement product = multiplicand.multiply(BigInteger.valueOf(34));
        Assertions.assertEquals(BigInteger.valueOf(3), product.value());
    }

    @Test
    public void testMultiplyLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 75);
        final GaloisElement product = multiplicand.multiply(34);
        Assertions.assertEquals(BigInteger.valueOf(3), product.value());
    }

    @Test
    public void testSubtractNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 99);
        final GaloisElement subtrahend = field.getAdditiveNeutralElement();
        final GaloisElement difference = minuend.subtract(subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(99), difference.value());
    }

    @Test
    public void testSubtract() {
        // 99 - 7 = 1100011 - 111 = 1100100 = 64 + 32 + 4 = 100
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 99);
        final GaloisElement subtrahend = new GaloisPolynomialElement(field, 7);
        final GaloisElement difference = minuend.subtract(subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(100), difference.value());
    }

    @Test
    public void testSubtractBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 99);
        final GaloisElement difference = minuend.subtract(BigInteger.valueOf(7));
        Assertions.assertEquals(BigInteger.valueOf(100), difference.value());
    }

    @Test
    public void testSubtractLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 285);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 99);
        final GaloisElement difference = minuend.subtract(7);
        Assertions.assertEquals(BigInteger.valueOf(100), difference.value());
    }
}
