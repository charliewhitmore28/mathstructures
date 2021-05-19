package com.caw.math.group.field.galois.algorithm.inverse;

import com.caw.math.group.field.galois.GaloisElement;
import com.caw.math.group.field.galois.GaloisPrimeElement;
import com.caw.math.group.field.galois.GaloisPrimeField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * A base test class for {@link GaloisInverse} implementations.
 *
 * @author cwhitmore
 */

public abstract class GaloisInverseTestCase {

    private GaloisInverse galoisInverse;

    @BeforeEach
    public void setUp() {
        galoisInverse = makeGaloisInverse();
    }

    @Test
    public void testInverseZero() {
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement element = field.element(BigInteger.ZERO);
        final GaloisElement inverse = galoisInverse.invert(element);
        Assertions.assertEquals(BigInteger.ZERO, inverse.value());
    }

    @Test
    public void testInverseMultiplicativeNeutralElementPrime() {
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement element = field.getMultiplicativeNeutralElement();
        final GaloisElement inverse = galoisInverse.invert(element);
        Assertions.assertEquals(element.value(), inverse.value());
    }

    @Test
    public void testInversePrime() {
        // 9 * x (mod 13) = 1
        // 9 * 3 (mod 13) = 27 (mod 13) = 1 => x = 3
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement element = field.element(9);
        final GaloisElement inverse = galoisInverse.invert(element);
        Assertions.assertEquals(BigInteger.valueOf(3), inverse.value());
    }

    @Test
    public void testInverseBigIntegerPrime() {
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement inverse = galoisInverse.invert(field, BigInteger.valueOf(9));
        Assertions.assertEquals(BigInteger.valueOf(3), inverse.value());
    }

    @Test
    public void testInverseLongPrime() {
        final GaloisPrimeField field = new GaloisPrimeField(13);
        final GaloisElement inverse = galoisInverse.invert(field, 9);
        Assertions.assertEquals(BigInteger.valueOf(3), inverse.value());
    }

    @Test
    public void testInverseStressPrime() {
        // 2,540,812 * 1,000,000 = 2,540,812,000,000 = (15,485,863 * 164073) + 1
        final GaloisPrimeField field = new GaloisPrimeField(15_485_863);
        final GaloisElement element = field.element(1_000_000);
        final GaloisElement inverse = galoisInverse.invert(element);
        Assertions.assertEquals(BigInteger.valueOf(2_540_812), inverse.value());
    }

    /**
     * Make a {@link GaloisInverse} implementation to test.
     */

    protected abstract GaloisInverse makeGaloisInverse();
}
