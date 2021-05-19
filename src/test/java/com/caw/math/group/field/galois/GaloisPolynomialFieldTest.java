package com.caw.math.group.field.galois;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * A test class for {@link GaloisPolynomialField} with a supplied {@code prime} >= two.
 *
 * @author cwhitmore
 */

public class GaloisPolynomialFieldTest {

    // Let's perform these operations underneath GF(5^8) with irreducible polynomial:
    // 838089 (2x^8 + 3x^6 + 3x^5 + 4x^3 + 3x^2 + 2x + 4)

    @Test
    public void testAddNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement augend = new GaloisPolynomialElement(field, 12_345);
        final GaloisElement addend = field.getAdditiveNeutralElement();
        final GaloisElement sum = field.add(augend, addend);
        Assertions.assertEquals(BigInteger.valueOf(12_345), sum.value());
    }

    @Test
    public void testAdd() {
        // 12345 = 3x^5 + 4x^4 + 3x^3 + 3x^2 + 4x
        // 54321 = 3x^6 + 2x^5 + x^4 + 4x^3 + 2x^2 + 4x + 1
        // 343340 + 3214241 = 3557581 = 3002031 = 3x^6 + 2x^3 + 3x + 1 = 46,875 + 250 + 15 + 1 = 47,141
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement augend = new GaloisPolynomialElement(field, 12_345);
        final GaloisElement addend = new GaloisPolynomialElement(field, 54_321);
        final GaloisElement sum = field.add(augend, addend);
        Assertions.assertEquals(BigInteger.valueOf(47_141), sum.value());
    }

    @Test
    public void testAddBigIntegers() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement sum = field.add(BigInteger.valueOf(12_345), BigInteger.valueOf(54_321));
        Assertions.assertEquals(BigInteger.valueOf(47_141), sum.value());
    }

    @Test
    public void testAddLongs() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement sum = field.add(12_345, 54_321);
        Assertions.assertEquals(BigInteger.valueOf(47_141), sum.value());
    }

    @Test
    public void testAdditiveInverseOfNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement element = field.getAdditiveNeutralElement();
        final GaloisElement inverse = field.additiveInverseOf(element);
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testAdditiveInverse() {
        // 280 = 2(125) + 1(25) + 1(5) = 2x^3 + x^2 + x
        // 2x^3 + x^2 + x * (?) = 0 => 3x^2 + 4x^2 + 4x = 3(125) + 4(25) + 4(5) = 375 + 100 + 20 = 495
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement element = new GaloisPolynomialElement(field, 280);
        final GaloisElement inverse = field.additiveInverseOf(element);
        Assertions.assertEquals(BigInteger.valueOf(495), inverse.value());
    }

    @Test
    public void testAdditiveInverseBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement inverse = field.additiveInverseOf(BigInteger.valueOf(280));
        Assertions.assertEquals(BigInteger.valueOf(495), inverse.value());
    }

    @Test
    public void testAdditiveInverseLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement inverse = field.additiveInverseOf(280);
        Assertions.assertEquals(BigInteger.valueOf(495), inverse.value());
    }

    @Test
    public void testDivideNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 2_468);
        final GaloisElement divisor = field.getMultiplicativeNeutralElement();
        final GaloisElement quotient = field.divide(dividend, divisor);
        Assertions.assertEquals(BigInteger.valueOf(2_468), quotient.value());
    }

    @Test
    public void testDivide() {
        // 2,468 = 3x^4 + 4x^3 + 3x^2 + 3x + 3
        // 13,579 = 4x^5 + x^4 + 3x^3 + 3x^2 + 4
        // Inverse of 13,579 = 374,642 = 4x^7 + 3x^6 + 4x^5 + 4x^4 + 2x^3 + 3x + 2
        // (3,4,3,3,3) * (4,3,4,4,2,0,3,2)
        // = (12,16,12,12,12,00,00,00,00,00,00,00)
        // + (00,09,12,09,09,09,00,00,00,00,00,00)
        // + (00,00,12,16,12,12,12,00,00,00,00,00)
        // + (00,00,00,12,16,12,12,12,00,00,00,00)
        // + (00,00,00,00,06,08,06,06,06,00,00,00)
        // + (00,00,00,00,00,00,09,12,09,09,09,00)
        // + (00,00,00,00,00,00,00,06,08,06,06,06)
        // = (12,25,36,49,55,41,39,36,23,15,15,06)
        // = (02,00,01,04,00,01,04,01,03,00,00,01) -> reducer
        // 201401413001 = 3102144001 = 130132241 = 31230334
        // 203304324<--   302201231< = 104402412
        // = 3(78125) + 15625 + 2(3125) + 3(625) + 3(25) + 3(5) + 4 = 258,219
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 2_468);
        final GaloisElement divisor = new GaloisPolynomialElement(field, 13_579);
        final GaloisElement quotient = field.divide(dividend, divisor);
        Assertions.assertEquals(BigInteger.valueOf(258_219), quotient.value());
    }

    @Test
    public void testDivideBigIntegers() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement quotient = field.divide(BigInteger.valueOf(2_468), BigInteger.valueOf(13_579));
        Assertions.assertEquals(BigInteger.valueOf(258_219), quotient.value());
    }

    @Test
    public void testDivideLongs() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement quotient = field.divide(2_468, 13_579);
        Assertions.assertEquals(BigInteger.valueOf(258_219), quotient.value());
    }

    @Test
    public void testMultiplicativeInverseOfNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement element = field.getMultiplicativeNeutralElement();
        final GaloisElement inverse = field.multiplicativeInverseOf(element);
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testMultiplicativeInverseOf() {
        // 4081 = x^5 + x^4 + 2x^3 + 3x^2 + x + 1
        // 112311 * (?) = 1 (mod 2x^8 + 3x^6 + 3x^5 + 4x^3 + 3x^2 + 2x + 4); ? = 45,405
        // 112311 * 2423210 = 210420302210
        // 210420302210 = 12121033210 = 12121033210 = 2231342010 = 203304320 = -4 = 1
        // 203304324<--   203304324<-   104402412<-   203304324<   203304324
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement element = new GaloisPolynomialElement(field, 4_081);
        final GaloisElement inverse = field.multiplicativeInverseOf(element);
        Assertions.assertEquals(BigInteger.valueOf(45_405), inverse.value());
    }

    @Test
    public void testMultiplicativeInverseOfBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement inverse = field.multiplicativeInverseOf(BigInteger.valueOf(4_081));
        Assertions.assertEquals(BigInteger.valueOf(45_405), inverse.value());
    }

    @Test
    public void testMultiplicativeInverseOfLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement inverse = field.multiplicativeInverseOf(4_081);
        Assertions.assertEquals(BigInteger.valueOf(45_405), inverse.value());
    }

    @Test
    public void testMultiplyNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 121_212);
        final GaloisElement multiplier = field.getMultiplicativeNeutralElement();
        final GaloisElement product = field.multiply(multiplicand, multiplier);
        Assertions.assertEquals(BigInteger.valueOf(121_212), product.value());
    }

    @Test
    public void testMultiply() {
        // 121212 = x^7 + 2x^6 + 3x^5 + 3x^4 + 4x^3 + 3x^2 + 2x + 2
        // 212121 = 2x^7 + 3x^6 + 2x^5 + 4x^4 + x^3 + 4x^2 + 4x + 1
        // 121212 * 212121 =
        // = (02,04,06,06,08,06,04,04,00,00,00,00,00,00,00)
        // + (00,03,06,09,09,12,09,06,06,00,00,00,00,00,00)
        // + (00,00,02,04,06,06,08,06,04,04,00,00,00,00,00)
        // + (00,00,00,04,08,12,12,16,12,08,08,00,00,00,00)
        // + (00,00,00,00,01,02,03,03,04,03,02,02,00,00,00)
        // + (00,00,00,00,00,04,08,12,12,16,12,08,08,00,00)
        // + (00,00,00,00,00,00,04,08,12,12,16,12,08,08,00)
        // + (00,00,00,00,00,00,00,01,02,03,03,04,03,02,02)
        // = (02,07,14,23,32,42,48,56,52,46,41,26,19,10,02)
        // = 224322312111402 = 21023043111402 = 1243111211402 = 204142141402 = 1343322402 = 304303332 = 2102101
        //   203304324<-----   203304324<----   104402412<---   203304324<--   104402412<   302201231
        // = 2x^6 + x^5 + 2x^3 + x^2 + 1 = 2(15,625) + 3,125 + 2(125) + 25 + 1 = 34,651
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 121_212);
        final GaloisElement multiplier = new GaloisPolynomialElement(field, 212_121);
        final GaloisElement product = field.multiply(multiplicand, multiplier);
        Assertions.assertEquals(BigInteger.valueOf(34_651), product.value());
    }

    @Test
    public void testMultiplyBigIntegers() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement product = field.multiply(BigInteger.valueOf(121_212), BigInteger.valueOf(212_121));
        Assertions.assertEquals(BigInteger.valueOf(34_651), product.value());
    }

    @Test
    public void testMultiplyLongs() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement product = field.multiply(121_212, 212_121);
        Assertions.assertEquals(BigInteger.valueOf(34_651), product.value());
    }

    @Test
    public void testSubtractNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 111_111);
        final GaloisElement subtrahend = field.getAdditiveNeutralElement();
        final GaloisElement difference = field.subtract(minuend, subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(111_111), difference.value());
    }

    @Test
    public void testSubtract() {
        // 111111 = x^7 + 2x^6 + 2x^4 + 3x^3 + 4x^2 + 2x + 1
        // 100000 = x^7 + x^6 + 2x^5
        // 111111 - 100000 = 12023421 - 11200000 = 0,1,-2,2,3,4,2,1 = 1323421
        // = 15,625 + 3(3,125) + 2(625) + 3(125) + 4(25) + 2(5) + 1 = 26,736
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 111_111);
        final GaloisElement subtrahend = new GaloisPolynomialElement(field, 100_000);
        final GaloisElement difference = field.subtract(minuend, subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(26_736), difference.value());
    }

    @Test
    public void testSubtractBigIntegers() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement difference = field.subtract(BigInteger.valueOf(111_111), BigInteger.valueOf(100_000));
        Assertions.assertEquals(BigInteger.valueOf(26_736), difference.value());
    }

    @Test
    public void testSubtractLongs() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 838_089);
        final GaloisElement difference = field.subtract(111_111, 100_000);
        Assertions.assertEquals(BigInteger.valueOf(26_736), difference.value());
    }
}
