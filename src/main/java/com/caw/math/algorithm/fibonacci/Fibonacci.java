package com.caw.math.algorithm.fibonacci;

import java.math.BigInteger;

/**
 * An interface for implementations of the fibonacci algorithm.
 *
 * @author cwhitmore
 */

public interface Fibonacci {

    /**
     * Calculate the fibonacci value for input {@code nthElement}, the n-th element in the fibonacci series.
     *
     * @param nthElement
     *      The input nthElement {@code nthElement}.
     * @return
     *      The fibonacci value for {@code nthElement}.
     */

    BigInteger calculate(final BigInteger nthElement);

    /**
     * Calculate the fibonacci value for input {@code nthElement}, the n-th element in the fibonacci series.
     *
     * @param nthElement
     *      The input nthElement {@code nthElement}.
     * @return
     *      The fibonacci value for {@code nthElement}.
     */

    BigInteger calculate(final long nthElement);
}
