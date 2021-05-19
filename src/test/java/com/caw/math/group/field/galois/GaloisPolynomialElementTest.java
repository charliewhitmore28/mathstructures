package com.caw.math.group.field.galois;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * Test class for {@link GaloisPolynomialElement} inside a {@link GaloisPolynomialField} with a supplied {@code prime}
 * of >= two.
 *
 * @author cwhitmore
 */

public class GaloisPolynomialElementTest {

    // Let's perform the operations from GaloisPolynomialFieldTest in GF(5^8) but with irreducible polynomial:
    // 390627 (x^8 + 2)

    @Test
    public void testAddNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement augend = new GaloisPolynomialElement(field, 12_345);
        final GaloisElement addend = field.getAdditiveNeutralElement();
        final GaloisElement sum = augend.add(addend);
        Assertions.assertEquals(BigInteger.valueOf(12_345), sum.value());
    }

    @Test
    public void testAdd() {
        // 12345 = 3x^5 + 4x^4 + 3x^3 + 3x^2 + 4x
        // 54321 = 3x^6 + 2x^5 + x^4 + 4x^3 + 2x^2 + 4x + 1
        // 343340 + 3214241 = 3557581 = 3002031 = 3x^6 + 2x^3 + 3x + 1 = 46,875 + 250 + 15 + 1 = 47,141
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement augend = new GaloisPolynomialElement(field, 12_345);
        final GaloisElement addend = new GaloisPolynomialElement(field, 54_321);
        final GaloisElement sum = augend.add(addend);
        Assertions.assertEquals(BigInteger.valueOf(47_141), sum.value());
    }

    @Test
    public void testAddBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement augend = new GaloisPolynomialElement(field, 12_345);
        final GaloisElement sum = augend.add(BigInteger.valueOf(54_321));
        Assertions.assertEquals(BigInteger.valueOf(47_141), sum.value());
    }

    @Test
    public void testAddLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement augend = new GaloisPolynomialElement(field, 12_345);
        final GaloisElement sum = augend.add(54_321);
        Assertions.assertEquals(BigInteger.valueOf(47_141), sum.value());
    }

    @Test
    public void testAdditiveInverseNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement element = field.getAdditiveNeutralElement();
        final GaloisElement inverse = element.additiveInverse();
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testAdditiveInverse() {
        // 280 = 2(125) + 1(25) + 1(5) = 2x^3 + x^2 + x
        // 2x^3 + x^2 + x * (?) = 0 => 3x^2 + 4x^2 + 4x = 3(125) + 4(25) + 4(5) = 375 + 100 + 20 = 495
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement element = new GaloisPolynomialElement(field, 280);
        final GaloisElement inverse = element.additiveInverse();
        Assertions.assertEquals(BigInteger.valueOf(495), inverse.value());
    }

    @Test
    public void testDivideNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 2_468);
        final GaloisElement divisor = field.getMultiplicativeNeutralElement();
        final GaloisElement quotient = dividend.divide(divisor);
        Assertions.assertEquals(BigInteger.valueOf(2_468), quotient.value());
    }

    @Test
    public void testDivide() {
        // 2,468 = 3x^4 + 4x^3 + 3x^2 + 3x + 3
        // 13,579 = 4x^5 + x^4 + 3x^3 + 3x^2 + 4
        // Inverse of 13,579 = 205,359 = 2x^7 + 3x^6 + 3x^4 + 2x^3 + 4x^2 + x + 4
        // (3,4,3,3,3) * (2,3,0,3,2,4,1,4)
        // = (06,08,06,06,06,00,00,00,00,00,00,00)
        // + (00,09,12,09,09,09,00,00,00,00,00,00)
        // + (00,00,00,09,12,09,09,09,00,00,00,00)
        // + (00,00,00,00,06,08,06,06,06,00,00,00)
        // + (00,00,00,00,00,12,16,12,12,12,00,00)
        // + (00,00,00,00,00,00,03,04,03,03,03,00)
        // + (00,00,00,00,00,00,00,12,16,12,12,12)
        // = (06,17,18,24,33,38,34,43,37,27,15,12)
        // = 123433432202 = 23433430202 = 3433430302 = 433430342 = 33430344
        //   100000002<--   200000004<-   300000001<   400000003
        // = 3(78,125) + 3(15,625) + 4(3,125) + 3(625) + 3(25) + 4(5) + 4 =
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 2_468);
        final GaloisElement divisor = new GaloisPolynomialElement(field, 13_579);
        System.out.println(divisor.multiplicativeInverse());
        final GaloisElement quotient = field.divide(dividend, divisor);
        Assertions.assertEquals(BigInteger.valueOf(295_724), quotient.value());
    }

    @Test
    public void testDivideBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 2_468);
        final GaloisElement quotient = dividend.divide(BigInteger.valueOf(13_579));
        Assertions.assertEquals(BigInteger.valueOf(295_724), quotient.value());
    }

    @Test
    public void testDivideLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement dividend = new GaloisPolynomialElement(field, 2_468);
        final GaloisElement quotient = dividend.divide(13_579);
        Assertions.assertEquals(BigInteger.valueOf(295_724), quotient.value());
    }

    @Test
    public void testMultiplicativeInverseNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement element = field.getMultiplicativeNeutralElement();
        final GaloisElement inverse = element.multiplicativeInverse();
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testMultiplicativeInverse() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement element = new GaloisPolynomialElement(field, 4_081);
        final GaloisElement inverse = element.multiplicativeInverse();
        Assertions.assertEquals(BigInteger.valueOf(186_199), inverse.value());
    }

    @Test
    public void testMultiplyNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 121_212);
        final GaloisElement multiplier = field.getMultiplicativeNeutralElement();
        final GaloisElement product = multiplicand.multiply(multiplier);
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
        // = 224322312111402 = 24322313111402 = 4322313211402 = 322313231402 = 22313230402 = 2313230002 = 313230012
        //   200000004<-----   200000004<----   400000003<---   300000001<--   200000004<-   200000004<   300000001
        // = 13230011 = 78,125 + 3(15,625) + 2(3,125) + 3(625) + 5 + 1 = 133,131
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 121_212);
        final GaloisElement multiplier = new GaloisPolynomialElement(field, 212_121);
        final GaloisElement product = multiplicand.multiply(multiplier);
        Assertions.assertEquals(BigInteger.valueOf(133_131), product.value());
    }

    @Test
    public void testMultiplyBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 121_212);
        final GaloisElement product = multiplicand.multiply(BigInteger.valueOf(212_121));
        Assertions.assertEquals(BigInteger.valueOf(133_131), product.value());
    }

    @Test
    public void testMultiplyLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement multiplicand = new GaloisPolynomialElement(field, 121_212);
        final GaloisElement product = multiplicand.multiply(212_121);
        Assertions.assertEquals(BigInteger.valueOf(133_131), product.value());
    }

    @Test
    public void testSubtractNeutralElement() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 111_111);
        final GaloisElement subtrahend = field.getAdditiveNeutralElement();
        final GaloisElement difference = minuend.subtract(subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(111_111), difference.value());
    }

    @Test
    public void testSubtract() {
        // 111111 = x^7 + 2x^6 + 2x^4 + 3x^3 + 4x^2 + 2x + 1
        // 100000 = x^7 + x^6 + 2x^5
        // 111111 - 100000 = 12023421 - 11200000 = 0,1,-2,2,3,4,2,1 = 1323421
        // = 15,625 + 3(3,125) + 2(625) + 3(125) + 4(25) + 2(5) + 1 = 26,736
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 111_111);
        final GaloisElement subtrahend = new GaloisPolynomialElement(field, 100_000);
        final GaloisElement difference = minuend.subtract(subtrahend);
        Assertions.assertEquals(BigInteger.valueOf(26_736), difference.value());
    }

    @Test
    public void testSubtractBigInteger() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 111_111);
        final GaloisElement difference = minuend.subtract(BigInteger.valueOf(100_000));
        Assertions.assertEquals(BigInteger.valueOf(26_736), difference.value());
    }

    @Test
    public void testSubtractLong() {
        final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
        final GaloisElement minuend = new GaloisPolynomialElement(field, 111_111);
        final GaloisElement difference = minuend.subtract(100_000);
        Assertions.assertEquals(BigInteger.valueOf(26_736), difference.value());
    }
}
