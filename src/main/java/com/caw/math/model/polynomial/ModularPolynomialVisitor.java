package com.caw.math.model.polynomial;

/**
 * Basic visitor implementation. The main purpose of this class is to prevent downstream abstractions from being
 * introduced as dependencies inside of the modular polynomials, but to allow for implementation-specific functionality
 * to be invoked on the different implementations of {@link ModularPolynomial}.
 *
 * @author cwhitmore
 */

public interface ModularPolynomialVisitor {

    /**
     * Visits the specified bitwise {@code polynomial}, performing implementation-specific operations on it.
     *
     * @param polynomial
     *      The bitwise {@code polynomial} to visit.
     * @return
     *      Some {@link ModularPolynomial} instance, controlled by the visitor implementation.
     */

    ModularPolynomial visit(final BitPolynomial polynomial);

    /**
     * Visits the specified non-bitwise {@code polynomial}, performing implementation-specific operations on it.
     *
     * @param polynomial
     *      The non-bitwise {@code polynomial} to visit.
     * @return
     *      Some {@link ModularPolynomial} instance, controlled by the visitor implementation.
     */

    ModularPolynomial visit(final NonBitPolynomial polynomial);
}
