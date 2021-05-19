package com.caw.math.algorithm.phi;

import com.caw.math.algorithm.gcd.GCD;
import com.caw.math.algorithm.gcd.GCDFactory;
import com.caw.math.group.ring.IntegerRing;

import java.math.BigInteger;

/**
 * An implementation of {@link Phi} that uses brute force to calculate the phi-value of an {@link IntegerRing}.
 *
 * @author cwhitmore
 */

public class BruteForcePhi implements Phi {

    private final GCD gcd;

    public BruteForcePhi() {
        this.gcd = GCDFactory.make();
    }

    public BruteForcePhi(final GCD gcd) {
        this.gcd = gcd;
    }

    @Override
    public BigInteger of(final IntegerRing ring) {

        final BigInteger ringSize = ring.size();
        BigInteger phi = BigInteger.ZERO;
        for (BigInteger i = BigInteger.ONE; i.compareTo(ringSize) < 0; i = i.add(BigInteger.ONE)) {
            if (gcd.calculate(i, ringSize).equals(BigInteger.ONE)) {
                phi = phi.add(BigInteger.ONE);
            }
        }
        return phi;
    }
}
