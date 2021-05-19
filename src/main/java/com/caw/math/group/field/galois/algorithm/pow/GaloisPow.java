package com.caw.math.group.field.galois.algorithm.pow;

import com.caw.math.group.field.galois.GaloisElement;
import com.caw.math.group.field.galois.GaloisField;

import java.math.BigInteger;

/**
 * An interface for algorithms that are able to calculate the value of a {@link GaloisElement} raised to some power
 * inside of a {@link GaloisField}.
 *
 * @author cwhitmore
 */

public interface GaloisPow {

    /**
     * Calculate the value of the specified {@code element} raised to the specified {@code power} inside of the element's
     * galois field, and return it as an element of the specified element's galois field.
     *
     * @param element
     *      The element to raise to the specified {@code power}.
     * @param power
     *      The power to raise the specified {@code element} by.
     * @return
     *      A new galois element with value equal to the specified {@code element} raised to the specified {@code power}
     *      inside of the specified element's galois field.
     */

    GaloisElement pow(final GaloisElement element, final BigInteger power);

    /**
     * Calculate the value of the specified {@code element} raised to the specified {@code power} inside of the element's
     * galois field, and return it as an element of the specified element's galois field.
     *
     * @param element
     *      The element to raise to the specified {@code power}.
     * @param power
     *      The power to raise the specified {@code element} by.
     * @return
     *      A new galois element with value equal to the specified {@code element} raised to the specified {@code power}
     *      inside of the specified element's galois field.
     */

    GaloisElement pow(final GaloisElement element, final long power);

    /**
     * Calculate the value of the specified {@code value} raised to the specified {@code power} inside of the specified
     * {@code field}, and return it as an element of the specified {@code field}.
     *
     * @param field
     *      The galois field to use for this pow operation.
     * @param value
     *      The value to raise to the specified {@code power}.
     * @param power
     *      The power to raise the specified {@code value} by.
     * @return
     *      A new galois element with value equal to the specified {@code value} raised to the specified {@code power}
     *      inside of the specified {@code field}.
     */

    GaloisElement pow(final GaloisField field, final BigInteger value, final BigInteger power);

    /**
     * Calculate the value of the specified {@code value} raised to the specified {@code power} inside of the specified
     * {@code field}, and return it as an element of the specified {@code field}.
     *
     * @param field
     *      The galois field to use for this pow operation.
     * @param value
     *      The value to raise to the specified {@code power}.
     * @param power
     *      The power to raise the specified {@code value} by.
     * @return
     *      A new galois element with value equal to the specified {@code value} raised to the specified {@code power}
     *      inside of the specified {@code field}.
     */

    GaloisElement pow(final GaloisField field, final long value, final long power);
}
