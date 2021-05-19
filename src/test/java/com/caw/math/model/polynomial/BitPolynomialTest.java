package com.caw.math.model.polynomial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

/**
 * Test class for {@link BitPolynomial}.
 *
 * @author cwhitmore
 */

public class BitPolynomialTest {

    @Test
    public void testNegativeBigIntegerValueIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BitPolynomial(BigInteger.valueOf(-1)));
    }

    @Test
    public void testNegativeLongValueIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BitPolynomial(-1));
    }

    @Test
    public void testAddZero() {
        final BitPolynomial augend = new BitPolynomial(55);
        final BitPolynomial sum = augend.add(new BitPolynomial(BigInteger.ZERO));
        Assertions.assertEquals(BigInteger.valueOf(55), sum.value());
    }

    @Test
    public void testAdd() {
        // 55 = 110111
        // 123 = 1111011
        // 55 + 123 = 1001100 = 76
        final BitPolynomial augend = new BitPolynomial(55);
        final BitPolynomial sum = augend.add(new BitPolynomial(123));
        Assertions.assertEquals(BigInteger.valueOf(76), sum.value());
    }

    @Test
    public void testAddBigInteger() {
        final BitPolynomial augend = new BitPolynomial(55);
        final BitPolynomial sum = augend.add(BigInteger.valueOf(123));
        Assertions.assertEquals(BigInteger.valueOf(76), sum.value());
    }

    @Test
    public void testAddLong() {
        final BitPolynomial augend = new BitPolynomial(55);
        final BitPolynomial sum = augend.add(123);
        Assertions.assertEquals(BigInteger.valueOf(76), sum.value());
    }

    @Test
    public void testCoefficientsZero() {
        final BitPolynomial bitPolynomial = new BitPolynomial(BigInteger.ZERO);
        Assertions.assertTrue(bitPolynomial.coefficients().isEmpty());
    }

    @Test
    public void testCoefficientsOne() {
        final BitPolynomial bitPolynomial = new BitPolynomial(BigInteger.ONE);
        final List<BigInteger> coefficients = bitPolynomial.coefficients();
        Assertions.assertEquals(1, coefficients.size());
        Assertions.assertEquals(BigInteger.ONE, coefficients.get(0));
    }

    @Test
    public void testCoefficients() {
        // 28 = 11100
        final BitPolynomial bitPolynomial = new BitPolynomial(28);
        final List<BigInteger> coefficients = bitPolynomial.coefficients();
        Assertions.assertEquals(5, coefficients.size());
        Assertions.assertEquals(BigInteger.ONE, coefficients.get(4));
        Assertions.assertEquals(BigInteger.ONE, coefficients.get(3));
        Assertions.assertEquals(BigInteger.ONE, coefficients.get(2));
        Assertions.assertEquals(BigInteger.ZERO, coefficients.get(1));
        Assertions.assertEquals(BigInteger.ZERO, coefficients.get(0));
    }

    @Test
    public void testDegreeZero() {
        final BitPolynomial bitPolynomial = new BitPolynomial(BigInteger.ZERO);
        Assertions.assertEquals(0, bitPolynomial.degree());
    }

    @Test
    public void testDegreeOne() {
        final BitPolynomial bitPolynomial = new BitPolynomial(BigInteger.ONE);
        Assertions.assertEquals(0, bitPolynomial.degree());
    }

    @Test
    public void testDegree() {
        // 55 = 110111
        final BitPolynomial bitPolynomial = new BitPolynomial(55);
        Assertions.assertEquals(5, bitPolynomial.degree());
    }

    @Test
    public void testMultiplyZero() {
        final BitPolynomial multiplicand = new BitPolynomial(55);
        final BitPolynomial product = multiplicand.multiply(new BitPolynomial(BigInteger.ZERO));
        Assertions.assertEquals(BigInteger.ZERO, product.value());
    }

    @Test
    public void testMultiplyOne() {
        final BitPolynomial multiplicand = new BitPolynomial(55);
        final BitPolynomial product = multiplicand.multiply(new BitPolynomial(BigInteger.ONE));
        Assertions.assertEquals(BigInteger.valueOf(55), product.value());
    }

    @Test
    public void testMultiply() {
        // 42 = 101010
        // 13 = 1101
        // 42 * 13 = 101010 + 10101000 + 101010000 = 111010010
        final BitPolynomial multiplicand = new BitPolynomial(42);
        final BitPolynomial product = multiplicand.multiply(new BitPolynomial(13));
        Assertions.assertEquals(BigInteger.valueOf(466), product.value());
    }

    @Test
    public void testMultiplyBigInteger() {
        final BitPolynomial multiplicand = new BitPolynomial(42);
        final BitPolynomial product = multiplicand.multiply(BigInteger.valueOf(13));
        Assertions.assertEquals(BigInteger.valueOf(466), product.value());
    }

    @Test
    public void testMultiplyLong() {
        final BitPolynomial multiplicand = new BitPolynomial(42);
        final BitPolynomial product = multiplicand.multiply(13);
        Assertions.assertEquals(BigInteger.valueOf(466), product.value());
    }

    @Test
    public void testSubtractZero() {
        final BitPolynomial minuend = new BitPolynomial(55);
        final BitPolynomial difference = minuend.subtract(new BitPolynomial(BigInteger.ZERO));
        Assertions.assertEquals(BigInteger.valueOf(55), difference.value());
    }

    @Test
    public void testSubtract() {
        // 21 = 10101
        // 55 = 110111
        // 21 - 55 = 100010 = 34
        final BitPolynomial minuend = new BitPolynomial(21);
        final BitPolynomial difference = minuend.subtract(new BitPolynomial(55));
        Assertions.assertEquals(BigInteger.valueOf(34), difference.value());
    }

    @Test
    public void testSubtractBigInteger() {
        final BitPolynomial minuend = new BitPolynomial(21);
        final BitPolynomial difference = minuend.subtract(BigInteger.valueOf(55));
        Assertions.assertEquals(BigInteger.valueOf(34), difference.value());
    }

    @Test
    public void testSubtractLong() {
        final BitPolynomial minuend = new BitPolynomial(21);
        final BitPolynomial difference = minuend.subtract(55);
        Assertions.assertEquals(BigInteger.valueOf(34), difference.value());
    }

    @Test
    public void testToStringZero() {
        final BitPolynomial bitPolynomial = new BitPolynomial(BigInteger.ZERO);
        Assertions.assertEquals("0", bitPolynomial.toString());
    }

    @Test
    public void testToStringOne() {
        final BitPolynomial bitPolynomial = new BitPolynomial(BigInteger.ONE);
        Assertions.assertEquals("1", bitPolynomial.toString());
    }

    @Test
    public void testToStringTwo() {
        final BitPolynomial bitPolynomial = new BitPolynomial(BigInteger.TWO);
        Assertions.assertEquals("x", bitPolynomial.toString());
    }

    @Test
    public void testToString() {
        final BitPolynomial bitPolynomial = new BitPolynomial(BigInteger.valueOf(42));
        Assertions.assertEquals("x^5 + x^3 + x", bitPolynomial.toString());
    }

}
