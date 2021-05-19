package com.caw.math.group.field.galois.algorithm.inverse;

import com.caw.math.group.field.galois.GaloisElement;
import com.caw.math.group.field.galois.GaloisField;

import java.math.BigInteger;

/**
 * An interface for algorithms that are able to calculate the inverse of a {@link GaloisElement} inside
 * of a {@link GaloisField} with respect to some operation.
 *
 * @author cwhitmore
 */

public interface GaloisInverse {

    /**
     * Calculate the inverse of the galois element in the galois element's galois field with respect to some operation.
     *
     * @param element
     *      The galois element to invert.
     * @return
     *      The inverted galois element; also a member of the galois element's galois field.
     */

    GaloisElement invert(final GaloisElement element);

    /**
     * Calculate the inverse of the specified value inside of the specified galois field.
     *
     * @param field
     *      The galois field to calculate the inverse inside of.
     * @param value
     *      The value to calculate the inverse of.
     * @return
     *      The inverse of the specified value; as a member of the galois field.
     */

    GaloisElement invert(final GaloisField field, final BigInteger value);

    /**
     * Calculate the inverse of the specified value inside of the specified galois field.
     *
     * @param field
     *      The galois field to calculate the inverse inside of.
     * @param value
     *      The value to calculate the inverse of.
     * @return
     *      The inverse of the specified value; as a member of the galois field.
     */

    GaloisElement invert(final GaloisField field, final long value);
}
