package com.caw.math.group.field.galois;

import com.caw.math.group.AdditionGroupElement;
import com.caw.math.group.MultiplicativeGroupElement;

import java.math.BigInteger;

/**
 * A base class for {@link GaloisElement} implementations.
 *
 * @author cwhitmore
 */

@SuppressWarnings("PMD.TooManyMethods")
public abstract class AbstractGaloisElement implements GaloisElement {

    private final GaloisField field;
    private final BigInteger value;

    /* default */ AbstractGaloisElement(final GaloisField field, final BigInteger value) {
        this.field = field;
        this.value = field.reduce(value);
    }

    @Override
    public GaloisElement add(final AdditionGroupElement addend) {
        return add(addend.value());
    }

    @Override
    public GaloisElement add(final BigInteger addend) {
        return field.add(value, addend);
    }

    @Override
    public GaloisElement add(final long addend) {
        return add(BigInteger.valueOf(addend));
    }

    @Override
    public GaloisElement additiveInverse() {
        return field.additiveInverseOf(value);
    }

    @Override
    public GaloisElement divide(final MultiplicativeGroupElement divisor) {
        return divide(divisor.value());
    }

    @Override
    public GaloisElement divide(final BigInteger divisor) {
        return field.divide(value, divisor);
    }

    @Override
    public GaloisElement divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    public GaloisField field() {
        return field;
    }

    @Override
    public GaloisElement multiplicativeInverse() {
        return field.multiplicativeInverseOf(value);
    }

    @Override
    public GaloisElement multiply(final MultiplicativeGroupElement multiplier) {
        return multiply(multiplier.value());
    }

    @Override
    public GaloisElement multiply(final BigInteger multiplier) {
        return field.multiply(value, multiplier);
    }

    @Override
    public GaloisElement multiply(final long multiplier) {
        return multiply(BigInteger.valueOf(multiplier));
    }

    @Override
    public GaloisElement subtract(final AdditionGroupElement subtrahend) {
        return subtract(subtrahend.value());
    }

    @Override
    public GaloisElement subtract(final BigInteger subtrahend) {
        return field.subtract(value, subtrahend);
    }

    @Override
    public GaloisElement subtract(final long subtrahend) {
        return subtract(BigInteger.valueOf(subtrahend));
    }

    @Override
    public BigInteger value() {
        return value;
    }
}
