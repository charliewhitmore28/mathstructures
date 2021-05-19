package com.caw.math.group;

import java.math.BigInteger;

/**
 * An extension of an {@link AbelianGroup} that supports the addition operation.
 *
 * @param <E>
 *     The group element type contained in the addition group.
 *
 * @author cwhitmore
 */

public interface AdditionGroup<E extends AdditionGroupElement> extends Group<E> {

    /**
     * Add two addition group elements inside of this addition group. This is a closed operation and the returned result
     * is also a member of this addition group. The inverse of the add operation is the subtract operation.
     *
     * @param augend
     *      The addition group element to use as the augend of this add operation.
     * @param addend
     *      The addition group element to use as the addend of this add operation.
     * @return
     *      The addition group element that is the sum of this add operation.
     */

    E add(final E augend, final E addend);

    /**
     * Add two values representing addition group elements inside of this addition group. This is a closed operation
     * and the returned result is a member of this addition group. The inverse of the add operation is the subtract
     * operation.
     *
     * @param augend
     *      The value representing an addition group element to use as the augend of this add operation.
     * @param addend
     *      The value representing an addition group element to use as the addend of this add operation.
     * @return
     *      The addition group element that is the sum of this add operation.
     */

    E add(final BigInteger augend, final BigInteger addend);

    /**
     * Add two values representing addition group elements inside of this addition group. This is a closed operation
     * and the returned result is a member of this addition group. The inverse of the add operation is the subtract
     * operation.
     *
     * @param augend
     *      The value representing an addition group element to use as the augend of this add operation.
     * @param addend
     *      The value representing an addition group element to use as the addend of this add operation.
     * @return
     *      The addition group element that is the sum of this add operation.
     */

    E add(final long augend, final long addend);

    /**
     * Calculate the additive inverse of the supplied addition group element inside of this addition group.
     *
     * @param element
     *      The addition group element to calculate the additive inverse of.
     * @return
     *      The additive inverse of the supplied addition group element; also a member of this addition group.
     */
    E additiveInverseOf(final E element);

    /**
     * Calculate the additive inverse of the supplied value representing an addition group element inside of this
     * addition group.
     *
     * @param value
     *      The value representing an addition group element to calculate the additive inverse of.
     * @return
     *      The additive inverse of the supplied value as a member of this addition group.
     */

    E additiveInverseOf(final BigInteger value);

    /**
     * Calculate the additive inverse of the supplied value representing an addition group element inside of this
     * addition group.
     *
     * @param value
     *      The value representing an addition group element to calculate the additive inverse of.
     * @return
     *      The additive inverse of the supplied value as a member of this addition group.
     */

    E additiveInverseOf(final long value);

    /**
     * Reports the neutral element of this addition group. The neutral element is the element that when applied
     * to any addition group element of this addition group as the augend or addend of the
     * add operation, the returned sum is the other element of the add operation.
     *
     * @return
     *      The additive neutral element of this addition group.
     */

    E getAdditiveNeutralElement();

    /**
     * Subtract two addition group elements inside of this addition group. This is a closed operation and the
     * returned result is also a member of this addition group. The inverse of the subtract operation is the
     * add operation.
     *
     * @param minuend
     *      The addition group element to use as the minuend of this subtract operation.
     * @param subtrahend
     *      The addition group element to use as the subtrahend of this divide operation.
     * @return
     *      The addition group element that is the difference of this subtract operation.
     */

    E subtract(final E minuend, final E subtrahend);

    /**
     * Subtract two values representing addition group elements inside of this addition group. This is a closed
     * operation and the returned result is a member of this addition group. The inverse of the subtract operation is
     * the add operation.
     *
     * @param minuend
     *      The value representing an addition group element to use as the minuend of this subtract operation.
     * @param subtrahend
     *      The value representing an addition group element to use as the subtrahend of this subtract operation.
     * @return
     *      The addition group element that is the difference of this subtract operation.
     */

    E subtract(final BigInteger minuend, final BigInteger subtrahend);

    /**
     * Subtract two values representing addition group elements inside of this addition group. This is a closed
     * operation and the returned result is a member of this addition group. The inverse of the subtract operation is
     * the add operation.
     *
     * @param minuend
     *      The value representing an addition group element to use as the minuend of this subtract operation.
     * @param subtrahend
     *      The value representing an addition group element to use as the subtrahend of this subtract operation.
     * @return
     *      The addition group element that is the difference of this subtract operation.
     */

    E subtract(final long minuend, final long subtrahend);
}
