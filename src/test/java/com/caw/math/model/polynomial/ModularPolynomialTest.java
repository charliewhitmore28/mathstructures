package com.caw.math.model.polynomial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ModularPolynomialTest {

    @Test
    public void testIllegalArgumentModulus() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ModularPolynomial.valueOf(new ArrayList<>(), BigInteger.ONE));
    }

    @Test
    public void testValueOfZero() {
        final List<BigInteger> coefficients = Collections.singletonList(BigInteger.ZERO);
        final BigInteger actual = ModularPolynomial.valueOf(coefficients, BigInteger.TWO);
        Assertions.assertEquals(BigInteger.ZERO, actual);
    }

    @Test
    public void testValueOfZeros() {
        final List<BigInteger> coefficients = Collections.nCopies(3, BigInteger.ZERO);
        final BigInteger actual = ModularPolynomial.valueOf(coefficients, 5);
        Assertions.assertEquals(BigInteger.ZERO, actual);
    }

    @Test
    public void testValueOfOnesBitPolynomial() {
        // 11111 = 16 + 8 + 4 + 2 + 1 = 31
        final List<BigInteger> coefficients = Collections.nCopies(5, BigInteger.ONE);
        final BigInteger actual = ModularPolynomial.valueOf(coefficients, BigInteger.TWO);
        Assertions.assertEquals(BigInteger.valueOf(31), actual);
    }

    @Test
    public void testValueOfBitPolynomial() {
        // 101010 = 32 + 8 + 2 = 42
        final List<BigInteger> coefficients = Arrays.asList(
                BigInteger.ZERO, BigInteger.ONE, BigInteger.ZERO, BigInteger.ONE, BigInteger.ZERO, BigInteger.ONE);
        final BigInteger actual = ModularPolynomial.valueOf(coefficients, BigInteger.TWO);
        Assertions.assertEquals(BigInteger.valueOf(42), actual);
    }

    @Test
    public void testValueOfBitPolynomialExceedsMod() {
        // 3232 = 1010 = 8 + 2 = 10
        final List<BigInteger> coefficients = Arrays.asList(
                BigInteger.TWO, BigInteger.valueOf(3), BigInteger.TWO, BigInteger.valueOf(3));
        final BigInteger actual = ModularPolynomial.valueOf(coefficients, BigInteger.TWO);
        Assertions.assertEquals(BigInteger.valueOf(10), actual);
    }

    @Test
    public void testValueOfModThreePolynomial() {
        // 12022 = 3^3 + 2 * 3^3 + 0 + 2 * 3 + 2 = 81 + 54 + 6 + 2 = 143
        final List<BigInteger> coefficients = Arrays.asList(
                BigInteger.TWO, BigInteger.TWO, BigInteger.ZERO, BigInteger.TWO, BigInteger.ONE);
        final BigInteger actual = ModularPolynomial.valueOf(coefficients, BigInteger.valueOf(3));
        Assertions.assertEquals(BigInteger.valueOf(143), actual);
    }

    @Test
    public void testValueOfModFivePolynomial() {
        //431 = 4 * 5^2 + 3 * 5 + 1 = 100 + 15 + 1 = 116
        final List<BigInteger> coefficients = Arrays.asList(
                BigInteger.ONE, BigInteger.valueOf(3), BigInteger.valueOf(4));
        final BigInteger actual = ModularPolynomial.valueOf(coefficients, 5);
        Assertions.assertEquals(BigInteger.valueOf(116), actual);
    }

    @Test
    public void testValueOfModFiveExceedsMod() {
        // 981 = 431 = 4 * 5^2 + 3 * 5 + 1 = 100 + 15 + 1 = 116
        final List<BigInteger> coefficients = Arrays.asList(
                BigInteger.ONE, BigInteger.valueOf(8), BigInteger.valueOf(9));
        final BigInteger actual = ModularPolynomial.valueOf(coefficients, 5);
        Assertions.assertEquals(BigInteger.valueOf(116), actual);
    }

    @Test
    public void testValueOfModFiveNegative() {
        // -1,3,-4 = 431 = 4 * 5^2 + 3 * 5 + 1 = 100 + 15 + 1 = 116
        final List<BigInteger> coefficients = Arrays.asList(
                BigInteger.valueOf(-4), BigInteger.valueOf(3), BigInteger.valueOf(-1));
        final BigInteger actual = ModularPolynomial.valueOf(coefficients, 5);
        Assertions.assertEquals(BigInteger.valueOf(116), actual);
    }
}
