package com.caw.math.model.polynomial;

import java.math.BigInteger;
import java.util.List;

/**
 * Factory class to abstract away the underlying implementations of {@link ModularPolynomial}. As a general rule, bitwise
 * polynomials and bitwise arithmetic is treated as the default use case for modular polynomials, and if no modulus is
 * provided, a default modulus of two will be interpreted and the {@link BitPolynomial} implementation will be
 * provided behind the scenes.
 *
 * @author cwhitmore
 */

public final class ModularPolynomialFactory {

    private ModularPolynomialFactory() {
        // disable public instantiation.
    }

    public static ValueSourceBuilder fromValue() {
        return new ValueSourceBuilder();
    }

    public static CoefficientSourceBuilder fromCoefficients() {
        return new CoefficientSourceBuilder();
    }

    public static class ValueSourceBuilder {
        private BigInteger value;
        private BigInteger modulus;

        public ValueSourceBuilder withValue(final BigInteger value) {
            this.value = value;
            return this;
        }

        public ValueSourceBuilder withValue(final long value) {
            this.value = BigInteger.valueOf(value);
            return this;
        }

        public ValueSourceBuilder withModulus(final BigInteger modulus) {
            this.modulus = modulus;
            return this;
        }

        public ValueSourceBuilder withModulus(final long modulus) {
            this.modulus = BigInteger.valueOf(modulus);
            return this;
        }

        public ModularPolynomial build() {

            if (this.modulus == null || this.modulus.equals(BigInteger.TWO)) {
                return new BitPolynomial(value);
            } else {
                return new NonBitPolynomial(value, modulus);
            }
        }
    }

    public static class CoefficientSourceBuilder {

        private List<BigInteger> coefficients;
        private BigInteger modulus;

        public CoefficientSourceBuilder withCoefficients(final List<BigInteger> coefficients) {
            this.coefficients = coefficients;
            return this;
        }

        public CoefficientSourceBuilder withModulus(final BigInteger modulus) {
            this.modulus = modulus;
            return this;
        }

        public CoefficientSourceBuilder withModulus(final long modulus) {
            this.modulus = BigInteger.valueOf(modulus);
            return this;
        }

        public ModularPolynomial build() {

            if (this.modulus == null || this.modulus.equals(BigInteger.TWO)) {
                return new BitPolynomial(coefficients);
            } else {
                return new NonBitPolynomial(coefficients, modulus);
            }
        }
    }
}
