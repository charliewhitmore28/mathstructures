package com.caw.math.group;

import java.math.BigInteger;

/**
 * An extension of an {@link AbelianGroupElement} that is a member of a {@link MultiplicativeGroup}.
 *
 * @author cwhitmore
 */

public interface MultiplicativeGroupElement extends AbelianGroupElement {

    /**
     * Divide this multiplicative group element by the specified {@code divisor} inside of this multiplicative group
     * element's multiplicative group.
     *
     * @param divisor
     *      The multiplicative group element to use as the divisor for this divide operation.
     * @return
     *      The quotient of this divide operation as a member of this multiplicative group element's multiplicative
     *      group.
     */

    MultiplicativeGroupElement divide(final MultiplicativeGroupElement divisor);

    /**
     * Divide this multiplicative group element by the specified {@code divisor} inside of this multiplicative group
     * element's multiplicative group.
     *
     * @param divisor
     *      The value representing a multiplicative group element to use as the divisor for this divide operation.
     * @return
     *      The quotient of this divide operation as a member of this multiplicative group element's multiplicative
     *      group.
     */

    MultiplicativeGroupElement divide(final BigInteger divisor);

    /**
     * Divide this multiplicative group element by the specified {@code divisor} inside of this multiplicative group
     * element's multiplicative group.
     *
     * @param divisor
     *      The value representing a multiplicative group element to use as the divisor for this divide operation.
     * @return
     *      The quotient of this divide operation as a member of this multiplicative group element's multiplicative
     *      group.
     */

    MultiplicativeGroupElement divide(final long divisor);

    /**
     * Reports the inverse of this multiplicative group element with respect to the multiplication operation inside of
     * the {@link MultiplicativeGroup} that this element is a part of.
     *
     * @return
     *      The multiplicative inverse of this multiplicative group element, also inside of this element's
     *      multiplicative group.
     */

    MultiplicativeGroupElement multiplicativeInverse();

    /**
     * Multiply this multiplicative group element by the specified {@code multiplier} inside of this multiplicative
     * group element's multiplicative group.
     *
     * @param multiplier
     *      The multiplicative group element to use as the multiplier for this multiply operation.
     * @return
     *      The product of this multiply operation.
     */

    MultiplicativeGroupElement multiply(final MultiplicativeGroupElement multiplier);

    /**
     * Multiply this multiplicative group element by the specified {@code multiplier} inside of this multiplicative
     * group element's multiplicative group.
     *
     * @param multiplier
     *      The value representing a multiplicative group element to use as the multiplier for this multiply operation.
     * @return
     *      The product of this multiply operation.
     */

    MultiplicativeGroupElement multiply(final BigInteger multiplier);

    /**
     * Multiply this multiplicative group element by the specified {@code multiplier} inside of this multiplicative
     * group element's multiplicative group.
     *
     * @param multiplier
     *      The value representing a multiplicative group element to use as the multiplier for this multiply operation.
     * @return
     *      The product of this multiply operation.
     */

    MultiplicativeGroupElement multiply(final long multiplier);
}
