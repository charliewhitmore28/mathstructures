package com.caw.math.algorithm.gcd;

import java.math.BigInteger;

/**
 * An interface for algorithms that calculate the greatest common divisor of dividends. The greatest common divisor is
 * defined as the largest value where the dividend(s) mod divisor all equal zero.
 *
 * @author cwhitmore
 */

public interface GCD {

    /**
     * Calculate the greatest common divisor of {@code dividend1} and {@code dividend2}.
     *
     * @param dividend1
     *      The first input number used to calculate the greatest common divisor.
     * @param dividend2
     *      The second input number used to calculate the greatest common divisor.
     * @return
     *      The greatest common divisor of {@code dividend1} and {@code dividend2}.
     */

    BigInteger calculate(final BigInteger dividend1, final BigInteger dividend2);

    /**
     * Calculate the greatest common divisor of {@code dividend1} and {@code dividend2}.
     *
     * @param dividend1
     *      The first input number used to calculate the greatest common divisor.
     * @param dividend2
     *      The second input number used to calculate the greatest common divisor.
     * @return
     *      The greatest common divisor of {@code dividend1} and {@code dividend2}.
     */

    BigInteger calculate(final long dividend1, final long dividend2);
}
