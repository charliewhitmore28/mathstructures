package com.caw.math.model.polynomial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

/**
 * Test class for {@link NonBitPolynomial}.
 *
 * @author cwhitmore
 */

public class NonBitPolynomialTest {

    @Test
    public void testNegativeBigIntegerValueIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NonBitPolynomial(BigInteger.valueOf(-1), BigInteger.valueOf(5)));
    }

    @Test
    public void testModulusTwoBigIntegerIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NonBitPolynomial(BigInteger.valueOf(123), BigInteger.TWO));
    }

    @Test
    public void testNegativeLongValueIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NonBitPolynomial(-1, 5));
    }

    @Test
    public void testModulusTwoLongIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NonBitPolynomial(123, 2));
    }

    @Test
    public void testAddZero() {
        final NonBitPolynomial augend = new NonBitPolynomial(55, 5);
        final NonBitPolynomial sum = augend.add(new NonBitPolynomial(0, 5));
        Assertions.assertEquals(BigInteger.valueOf(55), sum.value());
    }

    @Test
    public void testAdd() {
        // 55 (mod 5) = 2x^2 + x
        // 22 (mod 5) = 4x + 2
        // 55 + 22 = 2x^2 + 5x + 2 = 2x^2 + 2 = 52
        final NonBitPolynomial augend = new NonBitPolynomial(55, 5);
        final NonBitPolynomial sum = augend.add(new NonBitPolynomial(22, 5));
        Assertions.assertEquals(BigInteger.valueOf(52), sum.value());
    }

    @Test
    public void testAddBigInteger() {
        final NonBitPolynomial augend = new NonBitPolynomial(55, 5);
        final NonBitPolynomial sum = augend.add(BigInteger.valueOf(22));
        Assertions.assertEquals(BigInteger.valueOf(52), sum.value());
    }

    @Test
    public void testAddLong() {
        final NonBitPolynomial augend = new NonBitPolynomial(55, 5);
        final NonBitPolynomial sum = augend.add(22);
        Assertions.assertEquals(BigInteger.valueOf(52), sum.value());
    }

    @Test
    public void testCoefficientsZero() {
        final NonBitPolynomial nonBitPolynomial = new NonBitPolynomial(0, 7);
        final List<BigInteger> coefficients = nonBitPolynomial.coefficients();
        Assertions.assertEquals(1, coefficients.size());
        Assertions.assertEquals(BigInteger.ZERO, coefficients.get(0));
    }

    @Test
    public void testCoefficientsConstant() {
        final NonBitPolynomial nonBitPolynomial = new NonBitPolynomial(4, 7);
        final List<BigInteger> coefficients = nonBitPolynomial.coefficients();
        Assertions.assertEquals(1, coefficients.size());
        Assertions.assertEquals(BigInteger.valueOf(4), coefficients.get(0));
    }

    @Test
    public void testCoefficients() {
        // 123456 = x^6 (117,649) + 2x^4 (4,802) + 2x^3 (686) + 6x^2 (294) + 3x (21) + 4 (4)
        final NonBitPolynomial nonBitPolynomial = new NonBitPolynomial(123456, 7);
        final List<BigInteger> coefficients = nonBitPolynomial.coefficients();
        Assertions.assertEquals(7, coefficients.size());
        Assertions.assertEquals(BigInteger.valueOf(4), coefficients.get(0));
        Assertions.assertEquals(BigInteger.valueOf(3), coefficients.get(1));
        Assertions.assertEquals(BigInteger.valueOf(6), coefficients.get(2));
        Assertions.assertEquals(BigInteger.TWO, coefficients.get(3));
        Assertions.assertEquals(BigInteger.TWO, coefficients.get(4));
        Assertions.assertEquals(BigInteger.ZERO, coefficients.get(5));
        Assertions.assertEquals(BigInteger.ONE, coefficients.get(6));
    }

    @Test
    public void testDegreeZero() {
        final NonBitPolynomial nonBitPolynomial = new NonBitPolynomial(0, 3);
        Assertions.assertEquals(0, nonBitPolynomial.degree());
    }

    @Test
    public void testDegreeConstant() {
        final NonBitPolynomial nonBitPolynomial = new NonBitPolynomial(2, 3);
        Assertions.assertEquals(0, nonBitPolynomial.degree());
    }

    @Test
    public void testDegree() {
        // 99 (mod 3) = x^4 + 2x^2
        final NonBitPolynomial nonBitPolynomial = new NonBitPolynomial(99, 3);
        Assertions.assertEquals(4, nonBitPolynomial.degree());
    }

    @Test
    public void testMultiplyZero() {
        final NonBitPolynomial multiplicand = new NonBitPolynomial(77, 5);
        final NonBitPolynomial product = multiplicand.multiply(new NonBitPolynomial(0, 5));
        Assertions.assertEquals(BigInteger.ZERO, product.value());
    }

    @Test
    public void testMultiplyOne() {
        final NonBitPolynomial multiplicand = new NonBitPolynomial(77, 5);
        final NonBitPolynomial product = multiplicand.multiply(new NonBitPolynomial(1, 5));
        Assertions.assertEquals(BigInteger.valueOf(77), product.value());
    }

    @Test
    public void testMultiply() {
        // 77 (mod 5) =  3x^2 + 2
        // 22 (mod 5) = 4x + 2
        // 77 * 22 = (3x^2 + 2) * (4x + 2) = 12x^3 + 6x^2 + 8x + 4 = 2x^3 + x^2 + 3x + 4
        // = 250 + 25 + 15 + 4 = 294
        final NonBitPolynomial multiplicand = new NonBitPolynomial(77, 5);
        final NonBitPolynomial product = multiplicand.multiply(new NonBitPolynomial(22, 5));
        Assertions.assertEquals(BigInteger.valueOf(294), product.value());
    }

    @Test
    public void testMultiplyBigInteger() {
        final NonBitPolynomial multiplicand = new NonBitPolynomial(77, 5);
        final NonBitPolynomial product = multiplicand.multiply(BigInteger.valueOf(22));
        Assertions.assertEquals(BigInteger.valueOf(294), product.value());
    }

    @Test
    public void testMultiplyLong() {
        final NonBitPolynomial multiplicand = new NonBitPolynomial(77, 5);
        final NonBitPolynomial product = multiplicand.multiply(22);
        Assertions.assertEquals(BigInteger.valueOf(294), product.value());
    }

    @Test
    public void testSubtractZero() {
        final NonBitPolynomial subtrahend = new NonBitPolynomial(44, 3);
        final NonBitPolynomial difference = subtrahend.subtract(new NonBitPolynomial(0, 3));
        Assertions.assertEquals(BigInteger.valueOf(44), difference.value());
    }

    @Test
    public void testSubtract() {
        // 44 (mod 3) = x^3 (27) + x^2 (9) + 2x (6) + 2 (2)
        // 54 (mod 3) = 2x^3 (54)
        // 44 - 27 = -x^3 + x^2 + 2x + 2 = 2x^3 (54) + x^2 (9) + 2x (6) + 2 (2) = 71
        final NonBitPolynomial subtrahend = new NonBitPolynomial(44, 3);
        final NonBitPolynomial difference = subtrahend.subtract(new NonBitPolynomial(54, 3));
        Assertions.assertEquals(BigInteger.valueOf(71), difference.value());
    }

    @Test
    public void testSubtractBigInteger() {
        final NonBitPolynomial subtrahend = new NonBitPolynomial(44, 3);
        final NonBitPolynomial difference = subtrahend.subtract(BigInteger.valueOf(54));
        Assertions.assertEquals(BigInteger.valueOf(71), difference.value());
    }

    @Test
    public void testSubtractLong() {
        final NonBitPolynomial subtrahend = new NonBitPolynomial(44, 3);
        final NonBitPolynomial difference = subtrahend.subtract(54);
        Assertions.assertEquals(BigInteger.valueOf(71), difference.value());
    }

    @Test
    public void testToStringZero() {
        final NonBitPolynomial nonBitPolynomial = new NonBitPolynomial(BigInteger.ZERO, BigInteger.valueOf(5));
        Assertions.assertEquals("0", nonBitPolynomial.toString());
    }

    @Test
    public void testToStringOne() {
        final NonBitPolynomial nonBitPolynomial = new NonBitPolynomial(BigInteger.ONE, BigInteger.valueOf(5));
        Assertions.assertEquals("1", nonBitPolynomial.toString());
    }

    @Test
    public void testToStringTwo() {
        final NonBitPolynomial nonBitPolynomial = new NonBitPolynomial(BigInteger.TWO, BigInteger.valueOf(5));
        Assertions.assertEquals("2", nonBitPolynomial.toString());
    }

    @Test
    public void testToStringX() {
        final NonBitPolynomial nonBitPolynomial = new NonBitPolynomial(BigInteger.valueOf(5), BigInteger.valueOf(5));
        Assertions.assertEquals("x", nonBitPolynomial.toString());
    }

    @Test
    public void testToString() {
        final NonBitPolynomial nonBitPolynomial = new NonBitPolynomial(BigInteger.valueOf(1228), BigInteger.valueOf(5));
        Assertions.assertEquals("x^4 + 4x^3 + 4x^2 + 3", nonBitPolynomial.toString());
    }

}
