package com.caw.math.group.field.galois;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * Test class for {@link GaloisPolynomialField} where the supplied {@code prime} value is two.
 *
 * @author cwhitmore
 */

public class BitwiseGaloisPolynomialFieldTest {

    // Example irreducible polynomial from AES.
    // x^8 + x^4 + x^3 + x + 1 = 256 + 16 + 8 + 2 + 1 = 283

    @Test
    public void testAddNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement augend = new GaloisPolynomialElement(field, 49);
        final GaloisElement addend = field.getAdditiveNeutralElement();
        final GaloisElement sum = field.add(augend, addend);
        Assertions.assertEquals(BigInteger.valueOf(49), sum.value());
    }

    @Test
    public void testAddNoModRequired() {
        // 110001 + 110 = 110111 = 32 + 16 + 4 + 2 + 1 = 55
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement augend = new GaloisPolynomialElement(field, 49);
        final GaloisElement addend = new GaloisPolynomialElement(field, 6);
        final GaloisElement sum = field.add(augend, addend);
        Assertions.assertEquals(BigInteger.valueOf(55), sum.value());
    }

    @Test
    public void testAdd() {
        // 110001 + 101000 = 11001 = 16 + 8 + 1 = 25
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement augend = new GaloisPolynomialElement(field, 49);
        final GaloisElement addend = new GaloisPolynomialElement(field, 40);
        final GaloisElement sum = field.add(augend, addend);
        Assertions.assertEquals(BigInteger.valueOf(25), sum.value());
    }

    @Test
    public void testAddBigIntegers() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement sum = field.add(BigInteger.valueOf(49), BigInteger.valueOf(40));
        Assertions.assertEquals(BigInteger.valueOf(25), sum.value());
    }

    @Test
    public void testAddLongs() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement sum = field.add(49, 40);
        Assertions.assertEquals(BigInteger.valueOf(25), sum.value());
    }

    @Test
    public void testAdditiveInverseOfNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement element = field.getAdditiveNeutralElement();
        final GaloisElement inverse = field.additiveInverseOf(element);
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testAdditiveInverseOf() {
        // 1010101 + 1010101 = 0
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement element = new GaloisPolynomialElement(field, 85);
        final GaloisElement inverse = field.additiveInverseOf(element);
        Assertions.assertEquals(BigInteger.valueOf(85), inverse.value());
    }

    @Test
    public void testAdditiveInverseOfBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement inverse = field.additiveInverseOf(BigInteger.valueOf(85));
        Assertions.assertEquals(BigInteger.valueOf(85), inverse.value());
    }

    @Test
    public void testAdditiveInverseOfLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement inverse = field.additiveInverseOf(85);
        Assertions.assertEquals(BigInteger.valueOf(85), inverse.value());
    }

    @Test
    public void testDivideNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 30);
        final GaloisElement divisor = field.getMultiplicativeNeutralElement();
        final GaloisElement difference = field.divide(dividend, divisor);
        Assertions.assertEquals(BigInteger.valueOf(30), difference.value());
    }

    @Test
    public void testDivide() {
        // Inverse of 12 = 1100 * x (mod x^8 + x^4 + x^3 + x + 1) = 1?
        // 1100 * 10110000 (176) = 11000000000 + 110000000 + 11000000 = 11101000000 -> reduce
        // 11101000000 = 1100101100 = 100011010 = 1
        // 100011011<-   100011011<   100011011
        // 40 * 176 = 101000 * 10110000 = 1010000000000 + 10100000000 + 1010000000 = 1001110000000 -> reduce
        // 1001110000000 = 1000110000 = 110 = 6
        // 100011011<---   100011011<
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 40);
        final GaloisElement divisor = new GaloisPolynomialElement(field, 12);
        final GaloisElement quotient = field.divide(dividend, divisor);
        Assertions.assertEquals(BigInteger.valueOf(6), quotient.value());
    }

    @Test
    public void testDivideBigIntegers() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement quotient = field.divide(BigInteger.valueOf(40), BigInteger.valueOf(12));
        Assertions.assertEquals(BigInteger.valueOf(6), quotient.value());
    }

    @Test
    public void testDivideLongs() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement quotient = field.divide(40, 12);
        Assertions.assertEquals(BigInteger.valueOf(6), quotient.value());
    }

    @Test
    public void testMultiplicativeInverseOfNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement element = field.getMultiplicativeNeutralElement();
        final GaloisElement inverse = field.multiplicativeInverseOf(element);
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testMultiplicativeInverseOf() {
        // 101 = (1100101 * x) / (mod x^8 + x^4 + x^3 + x + 1) = 1?
        // 1100101 * 10100110 = 11001010000000 + 110010100000 + 110010100 + 11001010 = 11111101111110
        // 11111101111110 = 1110000011110 = 110110101110 = 10101110110 = 100011010 = 1
        // 100011011<----   100011011<---   100011011<--   100011011<-   100011011
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement element = new GaloisPolynomialElement(field, 101);
        final GaloisElement inverse = field.multiplicativeInverseOf(element);
        Assertions.assertEquals(BigInteger.valueOf(166), inverse.value());
    }

    @Test
    public void testMultiplicativeInverseOfBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement inverse = field.multiplicativeInverseOf(BigInteger.valueOf(101));
        Assertions.assertEquals(BigInteger.valueOf(166), inverse.value());
    }

    @Test
    public void testMultiplicativeInverseOfLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement inverse = field.multiplicativeInverseOf(101);
        Assertions.assertEquals(BigInteger.valueOf(166), inverse.value());
    }

    @Test
    public void testMultiplyNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 75);
        final GaloisElement multiplier = field.getMultiplicativeNeutralElement();
        final GaloisElement product = field.multiply(multiplicand, multiplier);
        Assertions.assertEquals(BigInteger.valueOf(75), product.value());
    }

    @Test
    public void testMultiplyNoModRequired() {
        // 6 * 3 = 110 * 11 = 1100 + 110 = 1010 = 10
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 6);
        final GaloisElement multiplier = new GaloisPolynomialElement(field, 3);
        final GaloisElement product = field.multiply(multiplicand, multiplier);
        Assertions.assertEquals(BigInteger.valueOf(10), product.value());
    }

    @Test
    public void testMultiply() {
        // 75 * 34 = 1001011 * 0100010 = 100101100000 + 10010110 = 100111110110 -> reducer (100011011)
        // 100111110110 = 100101110 -> reducer -> 100101110 = 110101 = 32 + 16 + 4 + 1 = 53
        // 100011011<--                           100011011
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 75);
        final GaloisElement multiplier = new GaloisPolynomialElement(field, 34);
        final GaloisElement product = field.multiply(multiplicand, multiplier);
        Assertions.assertEquals(BigInteger.valueOf(53), product.value());
    }

    @Test
    public void testMultiplyBigIntegers() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement product = field.multiply(BigInteger.valueOf(75), BigInteger.valueOf(34));
        Assertions.assertEquals(BigInteger.valueOf(53), product.value());
    }

    @Test
    public void testMultiplyLongs() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement product = field.multiply(75, 34);
        Assertions.assertEquals(BigInteger.valueOf(53), product.value());
    }

    @Test
    public void testSubtractNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 99);
        final GaloisElement subtrahend = field.getAdditiveNeutralElement();
        final GaloisElement difference = field.subtract(minuend, subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(99), difference.value());
    }

    @Test
    public void testSubtract() {
        // 99 - 7 = 1100011 - 111 = 1100100 = 64 + 32 + 4 = 100
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 99);
        final GaloisElement subtrahend = new GaloisPolynomialElement(field, 7);
        final GaloisElement difference = field.subtract(minuend, subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(100), difference.value());
    }

    @Test
    public void testSubtractBigIntegers() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement difference = field.subtract(BigInteger.valueOf(99), BigInteger.valueOf(7));
        Assertions.assertEquals(BigInteger.valueOf(100), difference.value());
    }

    @Test
    public void testSubtractLongs() {
        final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
        final GaloisElement difference = field.subtract(99, 7);
        Assertions.assertEquals(BigInteger.valueOf(100), difference.value());
    }


}
