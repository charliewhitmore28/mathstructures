package com.caw.math.group.ring.algorithm.phi;

import com.caw.math.group.ring.IntegerRing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public abstract class PhiTestCase {

    private Phi phi;

    @BeforeEach
    public void setUp() {
        phi = makePhi();
    }

    @Test
    public void testPhiZero() {
        final IntegerRing ring = new IntegerRing(0);
        final BigInteger actual = phi.of(ring);
        Assertions.assertEquals(BigInteger.ZERO, actual);
    }

    @Test
    public void testPhiOne() {
        final IntegerRing ring = new IntegerRing(1);
        final BigInteger actual = phi.of(ring);
        Assertions.assertEquals(BigInteger.ZERO, actual);
    }

    @Test
    public void testPhiTwo() {
        final IntegerRing ring = new IntegerRing(2);
        final BigInteger actual = phi.of(ring);
        Assertions.assertEquals(BigInteger.ONE, actual);
    }

    @Test
    public void testPhiFour() {
        final IntegerRing ring = new IntegerRing(4);
        final BigInteger actual = phi.of(ring);
        Assertions.assertEquals(BigInteger.TWO, actual);
    }

    @Test
    public void testPhiTwelve() {
        final IntegerRing ring = new IntegerRing(12);
        final BigInteger actual = phi.of(ring);
        Assertions.assertEquals(BigInteger.valueOf(4), actual);
    }

    @Test
    public void testPhiFifteen() {
        final IntegerRing ring = new IntegerRing(15);
        final BigInteger actual = phi.of(ring);
        Assertions.assertEquals(BigInteger.valueOf(8), actual);
    }

    @Test
    public void testPhi999() {
        final IntegerRing ring = new IntegerRing(999);
        final BigInteger actual = phi.of(ring);
        Assertions.assertEquals(BigInteger.valueOf(648), actual);
    }

    /**
     * Make an implementation of the {@link Phi} interface to test.
     */

    protected abstract Phi makePhi();
}
