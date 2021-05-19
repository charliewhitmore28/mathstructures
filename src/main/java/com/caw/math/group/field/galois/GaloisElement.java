package com.caw.math.group.field.galois;

import com.caw.math.group.AdditionGroupElement;
import com.caw.math.group.MultiplicativeGroupElement;
import com.caw.math.group.field.FieldElement;

import java.math.BigInteger;

/**
 * An extension of {@link FieldElement} which represents an element of a {@link GaloisField}.
 *
 * @author cwhitmore
 */

@SuppressWarnings("PMD.TooManyMethods")
public interface GaloisElement extends FieldElement {

    @Override
    GaloisElement add(final AdditionGroupElement addend);

    @Override
    GaloisElement add(final BigInteger addend);

    @Override
    GaloisElement add(final long addend);

    @Override
    GaloisElement additiveInverse();

    @Override
    GaloisElement divide(final MultiplicativeGroupElement divisor);

    @Override
    GaloisElement divide(final BigInteger divisor);

    @Override
    GaloisElement divide(final long divisor);

    /**
     * Reports the {@link GaloisField} instance that this galois element is a member of.
     *
     * @return
     *      The field that this galois element is a member of.
     */

    GaloisField field();

    @Override
    GaloisElement multiplicativeInverse();

    @Override
    GaloisElement multiply(final MultiplicativeGroupElement multiplier);

    @Override
    GaloisElement multiply(final BigInteger multiplier);

    @Override
    GaloisElement multiply(final long multiplier);

    @Override
    GaloisElement subtract(final AdditionGroupElement subtrahend);

    @Override
    GaloisElement subtract(final BigInteger subtrahend);

    @Override
    GaloisElement subtract(final long subtrahend);
}
