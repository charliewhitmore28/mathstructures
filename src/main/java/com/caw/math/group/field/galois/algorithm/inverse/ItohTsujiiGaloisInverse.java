package com.caw.math.group.field.galois.algorithm.inverse;

import com.caw.math.group.field.galois.GaloisElement;
import com.caw.math.group.field.galois.GaloisField;
import com.caw.math.group.field.galois.algorithm.pow.GaloisPow;
import com.caw.math.group.field.galois.algorithm.pow.GaloisPowFactory;

import java.math.BigInteger;

/**
 * An implementation of {@link GaloisInverse} that uses the Itoh-Tsujii algorithm to calculate the multiplicative
 * inverse of a {@link GaloisElement} inside of a {@link GaloisField}. This leverages a property of galois fields
 * where we have a guarantee that the multiplicative inverse of a galois element is that galois element raised to the
 * size of the galois field minus two.
 *
 * @author cwhitmore
 */

public class ItohTsujiiGaloisInverse implements GaloisInverse {

    // TODO: IoC?
    private final GaloisPow pow = GaloisPowFactory.make();

    /* default */ ItohTsujiiGaloisInverse() {
        // disable non-default instantiation.
    }

    @Override
    public GaloisElement invert(final GaloisElement element) {
        return pow.pow(element, element.field().size().subtract(BigInteger.TWO));
    }

    @Override
    public GaloisElement invert(final GaloisField field, final BigInteger value) {

        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Illegal parameter: value=" + value);
        }
        return invert(field.element(value));
    }

    @Override
    public GaloisElement invert(final GaloisField field, final long value) {
        return invert(field, BigInteger.valueOf(value));
    }
}
