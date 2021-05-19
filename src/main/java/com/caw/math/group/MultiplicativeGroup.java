package com.caw.math.group;

import java.math.BigInteger;

/**
 * An extension of an {@link AbelianGroup} that supports multiplicative operations.
 *
 * @param <E>
 *      The group element type contained in the multiplicative group.
 *
 * @author cwhitmore
 */

public interface MultiplicativeGroup<E extends MultiplicativeGroupElement> extends AbelianGroup<E> {

    /**
     * Divide two multiplicative group elements inside of this multiplicative group. This is a closed operation and the
     * returned result is also a member of this multiplicative group. The inverse of the divide operation is the
     * multiply operation.
     *
     * @param dividend
     *      The multiplicative group element to use as the dividend of this divide operation.
     * @param divisor
     *      The multiplicative group element to use as the divisor of this divide operation.
     * @return
     *      The multiplicative group element that is the quotient of this divide operation.
     */

    E divide(final E dividend, final E divisor);

    /**
     * Divide two values representing multiplicative group elements inside of this multiplicative group. This is a
     * closed operation and the returned result is a member of this multiplicative group. The inverse of the divide
     * operation is the multiply operation.
     *
     * @param dividend
     *      The value representing a multiplicative group element to use as the dividend of this divide operation.
     * @param divisor
     *      The value representing a multiplicative group element to use as the divisor of this divide operation.
     * @return
     *      The multiplicative group element that is the quotient of this divide operation.
     */

    E divide(final BigInteger dividend, final BigInteger divisor);

    /**
     * Divide two values representing multiplicative group elements inside of this multiplicative group. This is a
     * closed operation and the returned result is a member of this multiplicative group. The inverse of the divide
     * operation is the multiply operation.
     *
     * @param dividend
     *      The value representing a multiplicative group element to use as the dividend of this divide operation.
     * @param divisor
     *      The value representing a multiplicative group element to use as the divisor of this divide operation.
     * @return
     *      The multiplicative group element that is the quotient of this divide operation.
     */

    E divide(final long dividend, final long divisor);

    /**
     * Reports the neutral element of this multiplicative group. The neutral element is the element that when applied
     * to any multiplicative group element of this multiplicative group as the multiplicand or multiplier of the
     * multiply operation, the returned product is the other element of the multiply operation.
     *
     * @return
     *      The multiplicative neutral element of this multiplicative group.
     */

    E getMultiplicativeNeutralElement();

    /**
     * Calculate the multiplicative inverse of the supplied multiplicative group element inside of this multiplicative
     * group.
     *
     * @param element
     *      The multiplicative group element to calculate the multiplicative inverse of.
     * @return
     *      The multiplicative inverse of the supplied multiplicative group element; also a member of this
     *      multiplicative group.
     */

    E multiplicativeInverseOf(final E element);

    /**
     * Calculate the multiplicative inverse of the supplied value representing a multiplicative group element inside of
     * this multiplicative group.
     *
     * @param value
     *      The value representing a multiplicative group element to calculate the multiplicative inverse of.
     * @return
     *      The multiplicative inverse of the supplied value as a member of this multiplicative group.
     */

    E multiplicativeInverseOf(final BigInteger value);

    /**
     * Calculate the multiplicative inverse of the supplied value representing a multiplicative group element inside of
     * this multiplicative group.
     *
     * @param value
     *      The value representing a multiplicative group element to calculate the multiplicative inverse of.
     * @return
     *      The multiplicative inverse of the supplied value as a member of this multiplicative group.
     */

    E multiplicativeInverseOf(final long value);

    /**
     * Multiply two multiplicative group elements inside of this multiplicative group. This is a closed operation and
     * the returned result is also a member of this multiplicative group. The inverse of the multiply operation is the
     * divide operation.
     *
     * @param multiplicand
     *      The multiplicative group element to use as the multiplicand of this multiply operation.
     * @param multiplier
     *      The multiplicative group element to use as the multiplier of this multiply operation.
     * @return
     *      The multiplicative group element that is the product of this multiply operation.
     */

    E multiply(final E multiplicand, final E multiplier);

    /**
     * Multiply two values representing multiplicative group elements inside of this multiplicative group. This is a
     * closed operation and the returned result is a member of this multiplicative group. The inverse of the multiply
     * operation is the divide operation.
     *
     * @param multiplicand
     *      The value representing a multiplicative group element to use as the multiplicand of this multiply operation.
     * @param multiplier
     *      The value representing a multiplicative group element to use as the multiplier of this multiply operation.
     * @return
     *      The multiplicative group element that is the product of this multiply operation.
     */

    E multiply(final BigInteger multiplicand, final BigInteger multiplier);

    /**
     * Multiply two values representing multiplicative group elements inside of this multiplicative group. This is a
     * closed operation and the returned result is a member of this multiplicative group. The inverse of the multiply
     * operation is the divide operation.
     *
     * @param multiplicand
     *      The value representing a multiplicative group element to use as the multiplicand of this multiply operation.
     * @param multiplier
     *      The value representing a multiplicative group element to use as the multiplier of this multiply operation.
     * @return
     *      The multiplicative group element that is the product of this multiply operation.
     */

    E multiply(final long multiplicand, final long multiplier);
}
