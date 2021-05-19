package com.caw.math.group.field.galois;

import com.caw.math.group.field.Field;

import java.math.BigInteger;

/**
 * An extension of {@link Field} that is guaranteed to conceptually finite.
 *
 * @author cwhitmore
 */

public interface GaloisField extends Field<GaloisElement> {

    /**
     * Retrieves the field element associated with the supplied {@code value}. Any {@link BigInteger} value will uniquely
     * correspond to some {@link GaloisElement}, although some form of translation may have to be applied i.e. if the
     * field consists of polynomials.
     *
     * @param value
     *      The numeric representation of the galois field element to retrieve
     * @return
     *      The galois field element associated with the supplied {@code value}.
     */

    GaloisElement element(final BigInteger value);

    /**
     * Retrieves the field element associated with the supplied {@code value}. Any {@link BigInteger} value will uniquely
     * correspond to some {@link GaloisElement}, although some form of translation may have to be applied i.e. if the
     * field consists of polynomials.
     *
     * @param value
     *      The numeric representation of the galois field element to retrieve
     * @return
     *      The galois field element associated with the supplied {@code value}.
     */

    GaloisElement element(final long value);

    /**
     * Report the prime value used to construct this galois field.
     *
     * @return
     *      The prime value used to construct this galois field.
     */

    BigInteger prime();

    /**
     * Report the prime power used to construct this galois field. In the case of a prime field, this is most likely
     * equal to one. In the case of a polynomial field, this is most likely equal to the degree of polynomial allowed.
     *
     * @return
     *      The prime power used to construct this galois field.
     */

    int primePower();

    /**
     * Reduce the specified {@code value} to a value that is a member of this galois field in such a way that the
     * return value is equivalent to the specified {@code value} in this field.
     *
     * @param value
     *      The {@code value} to reduce.
     * @return
     *      The reduced value that is now a member of this galois field.
     */

    BigInteger reduce(final BigInteger value);

    /**
     * The size of this galois field. For example, in the case of a prime field, the size is most likely the prime
     * value used to construct the field. In the case of a polynomial field, the size is most likely the prime used
     * to construct the field raised to some prime power corresponding to the polynomial degree allowed.
     *
     * @return
     *      The size of this galois field.
     */

    BigInteger size();
}
