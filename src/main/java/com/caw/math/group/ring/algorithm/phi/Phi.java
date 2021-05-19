package com.caw.math.group.ring.algorithm.phi;

import com.caw.math.group.ring.IntegerRing;

import java.math.BigInteger;

/**
 * An interface for algorithms which calculate the phi value of an integer ring. The phi value of an integer ring is
 * the number of integers in the integer ring that are relatively prime to the integer ring size.
 *
 * @author cwhitmore.
 */

public interface Phi {

    /**
     * Calculate the phi value of the specified {@code ring}, returning the number of integers in the ring that are
     * relatively prime to the {@code ring} size.
     *
     * @param ring
     *      The {@link IntegerRing} to calculate the phi value of.
     * @return
     *      The number of integers in the ring that are relatively prime to the integer ring size.
     */

    BigInteger of(final IntegerRing ring);
}
