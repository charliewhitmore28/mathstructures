package com.caw.math.model.polynomial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An interface for polynomials of potentially infinite degree, but usually finite; and with coefficients that respect
 * a modulus factor. For example, for a modular polynomial with modulus 5, x^3 + 4x + 2 would be a valid modular
 * polynomial; whereas x^3 + 6x + 2 would be transformed to be x^3 + x + 2.
 *
 * @author cwhitmore
 */

@SuppressWarnings("PMD.TooManyMethods")
public interface ModularPolynomial {

    /**
     * Accepts the specified {@code visitor}.
     *
     * @param visitor
     *      The {@link ModularPolynomialVisitor} to accept, which performs some implementation-specific functionality
     *      on the different implementations of {@link ModularPolynomial}.
     * @return
     *      Some instance of a {@code ModularPolynomial}, controlled by the visitor implementation.
     */

    ModularPolynomial accepts(final ModularPolynomialVisitor visitor);

    /**
     * Return a new {@link ModularPolynomial} that is the result of adding the specified {@code addend} to this
     * polynomial.
     *
     * @param addend
     *      The polynomial to treat as the addend for this add operation.
     * @return
     *      A new polynomial that is the sum of adding the specified {@code addend} to this polynomial.
     */

    ModularPolynomial add(final ModularPolynomial addend);

    /**
     * Return a new {@link ModularPolynomial} that is the sum of adding the specified {@code addend} to this
     * polynomial.
     *
     * @param addend
     *      A {@link BigInteger} value representing a modular polynomial to treat as the addend in this add operation.
     * @return
     *      A new polynomial that is the sum of adding the specified {@code addend} to this polynomial.
     */

    ModularPolynomial add(final BigInteger addend);

    /**
     * Return a new {@link ModularPolynomial} that is the sum of adding the specified {@code addend} to this
     * polynomial.
     *
     * @param addend
     *      A {@link Long} value representing a modular polynomial to treat as the addend in this add operation.
     * @return
     *      A new polynomial that is the sum of adding the specified {@code addend} to this polynomial.
     */

    ModularPolynomial add(final long addend);

    /**
     * Report the {@link List} of coefficients that make up this polynomial.
     *
     * @return
     *      A list of the coefficients that make up this polynomial.
     */

    List<BigInteger> coefficients();

    /**
     * Report the degree of this polynomial.
     *
     * @return
     *      The degree of this polynomial.
     */

    int degree();

    /**
     * Report the modulus of this modular polynomial.
     *
     * @return
     *      The modulus of this modular polynomial.
     */

    BigInteger modulus();

    /**
     * Return a new {@link ModularPolynomial} that is the product of multiplying the specified {@code multiplier} with
     * this polynomial.
     *
     * @param multiplier
     *      The polynomial to treat as the multiplier in this multiply operation.
     * @return
     *      A new polynomial that is the product of multiplying the specified {@code multiplier} with this polynomial.
     */

    ModularPolynomial multiply(final ModularPolynomial multiplier);

    /**
     * Return a new {@link ModularPolynomial} that is the product of multiplying the specified {@code multiplier} with
     * this polynomial.
     *
     * @param multiplier
     *      A {@link BigInteger} value representing a modular polynomial to treat as the multiplier in this multiply
     *      operation.
     * @return
     *      A new polynomial that is the product of multiplying the specified {@code multiplier} with this polynomial.
     */

    ModularPolynomial multiply(final BigInteger multiplier);

    /**
     * Return a new {@link ModularPolynomial} that is the product of multiplying the specified {@code multiplier} with
     * this polynomial.
     *
     * @param multiplier
     *      A {@link Long} value representing a modular polynomial to treat as the multiplier in this multiply
     *      operation.
     * @return
     *      A new polynomial that is the product of multiplying the specified {@code multiplier} with this polynomial.
     */

    ModularPolynomial multiply(final long multiplier);

    /**
     * Return a new {@link ModularPolynomial} where each individual coefficient has been multiplied by the specified
     * {@code factor}.
     *
     * @param factor
     *      The {@code factor} to scale each coefficient by.
     * @return
     *      A new polynomial that is the result of scaling each individual coefficient by {@code factor}.
     */

    ModularPolynomial scale(final BigInteger factor);

    /**
     * Return a new {@link ModularPolynomial} where each individual coefficient has been multiplied by the specified
     * {@code factor}.
     *
     * @param factor
     *      The {@code factor} to scale each coefficient by.
     * @return
     *      A new polynomial that is the result of scaling each individual coefficient by {@code factor}.
     */

    ModularPolynomial scale(final long factor);

    /**
     * Return a new {@link ModularPolynomial} that is the difference of subtracting the specified {@code subtrahend} from
     * this polynomial.
     *
     * @param subtrahend
     *      The polynomial to treat as the subtrahend in this subtract operation.
     * @return
     *      A new polynomial that is the difference of subtracting the specified {@code subtrahend} from this polynomial.
     */

    ModularPolynomial subtract(final ModularPolynomial subtrahend);

    /**
     * Return a new {@link ModularPolynomial} that is the difference of subtracting the specified {@code subtrahend} from
     * this polynomial.
     *
     * @param subtrahend
     *      A {@link BigInteger} value representing a modular polynomial to treat as the subtrahend in this subtract
     *      operation.
     * @return
     *      A new polynomial that is the difference of subtracting the specified {@code subtrahend} from this polynomial.
     */

    ModularPolynomial subtract(final BigInteger subtrahend);

    /**
     * Return a new {@link ModularPolynomial} that is the difference of subtracting the specified {@code subtrahend} from
     * this polynomial.
     *
     * @param subtrahend
     *      A {@link Long} value representing a modular polynomial to treat as the subtrahend in this subtract
     *      operation.
     * @return
     *      A new polynomial that is the difference of subtracting the specified {@code subtrahend} from this polynomial.
     */

    ModularPolynomial subtract(final long subtrahend);

    /**
     * Report the value of this modular polynomial.
     *
     * @return
     *      The value of this modular polynomial.
     */

    BigInteger value();

    /**
     * Convert a {@link ModularPolynomial} into a list of polynomial coefficients representing the modular polynomial.
     *
     * @param polynomial
     *      The modular polynomial to convert to its coefficients.
     * @return
     *      The {@link List} of coefficients representing the specified {@code polynomial}.
     */

    static List<BigInteger> coefficientsOf(ModularPolynomial polynomial) {

        BigInteger value = polynomial.value();
        int degree = polynomial.degree();
        List<BigInteger> coefficients = new ArrayList<>(Collections.nCopies(degree + 1, BigInteger.ZERO));

        while (!value.equals(BigInteger.ZERO)) {

            BigInteger divisor = polynomial.modulus().pow(degree);
            BigInteger[] divideAndRemainder = value.divideAndRemainder(divisor);

            coefficients.set(degree, divideAndRemainder[0]);
            value = divideAndRemainder[1];
            degree--;
        }

        return coefficients;
    }

    /**
     * Convert a {@link ModularPolynomial} into a list of polynomial coefficients representing the modular polynomial.
     *
     * @param value
     *      The value representing a modular polynomial.
     * @param modulus
     *      The modulus of the modular polynomial.
     * @return
     *      The {@link List} of coefficients representing the modular polynomial with the specified {@code value} and
     *      {@code modulus}.
     */

    static List<BigInteger> coefficientsOf(final BigInteger value,
                                           final BigInteger modulus) {
        final ModularPolynomial polynomial = ModularPolynomialFactory.fromValue()
                .withValue(value)
                .withModulus(modulus)
                .build();
        return coefficientsOf(polynomial);
    }

    /**
     * Convert a {@link List} of coefficients into a {@link BigInteger} value representing the polynomial with those
     * coefficients. The main use of this method is to re-calculate the {@code value} of this polynomial after mathematical
     * operations have been performed, changing the coefficients of this polynomial.
     *
     * @param coefficients
     *      The list of coefficients to convert.
     * @return
     *      The value of the polynomial represented by the specified {@code coefficients}.
     */

    static BigInteger valueOf(final List<BigInteger> coefficients,
                              final BigInteger modulus) {

        if (modulus.compareTo(BigInteger.TWO) < 0) {
            throw new IllegalArgumentException("Illegal parameter: modulus=" + modulus);
        }

        BigInteger value = BigInteger.ZERO;
        BigInteger factor = BigInteger.ONE;

        for (final BigInteger coefficient : coefficients) {
            final BigInteger reducedCoefficient = coefficient.mod(modulus);
            value = value.add(reducedCoefficient.multiply(factor));
            factor = factor.multiply(modulus);
        }

        return value;
    }

    /**
     * Convert a {@link List} of coefficients into a {@link BigInteger} value representing the polynomial with those
     * coefficients. The main use of this method is to re-calculate the {@code value} of this polynomial after mathematical
     * operations have been performed, changing the coefficients of this polynomial.
     *
     * @param coefficients
     *      The list of coefficients to convert.
     * @return
     *      The value of the polynomial represented by the specified {@code coefficients}.
     */

    static BigInteger valueOf(final List<BigInteger> coefficients,
                              final long modulus) {

        return valueOf(coefficients, BigInteger.valueOf(modulus));
    }
}
