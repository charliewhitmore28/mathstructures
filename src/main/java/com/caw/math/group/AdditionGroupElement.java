package com.caw.math.group;

import java.math.BigInteger;

/**
 * An extension of an {@link AbelianGroupElement} that is a member of an {@link AdditionGroup}.
 *
 * @author cwhitmore
 */

public interface AdditionGroupElement extends AbelianGroupElement {

    /**
     * Add the specified addition group element to this addition group element inside of this addition group element's
     * addition group.
     *
     * @param addend
     *      The addition group element to use as the addend for this add operation.
     * @return
     *      The sum of this addition group element and the specified addend inside of this addition group element's
     *      addition group.
     */

    AdditionGroupElement add(final AdditionGroupElement addend);

    /**
     * Add the specified value representing an addition group element to this addition group element inside of this
     * addition group element's addition group.
     *
     * @param addend
     *      The value representing an addition group element to use as the addend for this add operation.
     * @return
     *      The sum of this addition group element and the specified addend inside of this addition group element's
     *      addition group.
     */

    AdditionGroupElement add(final BigInteger addend);

    /**
     * Add the specified value representing an addition group element to this addition group element inside of this
     * addition group element's addition group.
     *
     * @param addend
     *      The value representing an addition group element to use as the addend for this add operation.
     * @return
     *      The sum of this addition group element and the specified addend inside of this addition group element's
     *      addition group.
     */

    AdditionGroupElement add(final long addend);

    /**
     * Reports the inverse of this addition group element with respect to the addition operation inside of the
     * {@link AdditionGroup} that this element is a part of.
     *
     * @return
     *      The additive inverse of this addition group element, also inside of this element's addition group.
     */

    AdditionGroupElement additiveInverse();

    /**
     * Subtract the specified addition group element from this addition group element inside of this addition group
     * element's addition group.
     *
     * @param subtrahend
     *      The addition group element to use as the subtrahend for this subtract operation.
     * @return
     *      The difference of this addition group element and the specified subtrahend inside of this addition group
     *      element's addition group.
     */

    AdditionGroupElement subtract(final AdditionGroupElement subtrahend);

    /**
     * Subtract the specified value representing an addition group element from this addition group element inside of
     * this addition group element's addition group.
     *
     * @param subtrahend
     *      The value representing an addition group element to use as the subtrahend for this subtract operation.
     * @return
     *      The difference of this addition group element and the specified subtrahend inside of this addition group
     *      element's addition group.
     */

    AdditionGroupElement subtract(final BigInteger subtrahend);

    /**
     * Subtract the specified value representing an addition group element from this addition group element inside of
     * this addition group element's addition group.
     *
     * @param subtrahend
     *      The value representing an addition group element to use as the subtrahend for this subtract operation.
     * @return
     *      The difference of this addition group element and the specified subtrahend inside of this addition group
     *      element's addition group.
     */

    AdditionGroupElement subtract(final long subtrahend);
}
