package com.caw.math.group.field.galois;

import com.caw.math.model.polynomial.ModularPolynomial;
import com.caw.math.model.polynomial.ModularPolynomialFactory;

import java.math.BigInteger;

/**
 * An extension of {@link AbstractGaloisElement} that represents an element of a {@link GaloisPolynomialField}.
 *
 * @author cwhitmore
 */

public class GaloisPolynomialElement extends AbstractGaloisElement {

    /* default */ GaloisPolynomialElement(final GaloisPolynomialField field, final BigInteger value) {
        super(field, value);
    }

    /* default */ GaloisPolynomialElement(final GaloisPolynomialField field, final long value) {
        this(field, BigInteger.valueOf(value));
    }

    @Override
    public String toString() {
        final ModularPolynomial modularPolynomial = ModularPolynomialFactory.fromValue()
                .withValue(value())
                .withModulus(field().prime())
                .build();
        return getClass().getSimpleName() + "[value=" + value() + ", polynomial=" + modularPolynomial + "]";
    }
}
