package com.caw.math.algorithm.phi;

/**
 * A factory class which provides {@link Phi} implementations.
 *
 * @author cwhitmore
 */

public final class PhiFactory {

    private PhiFactory() {
        // disable public instantiation.
    }

    /**
     * Return a new instance of the default {@link BruteForcePhi} implementation.
     *
     * @return
     *      A new instance of the default {@link BruteForcePhi} implementation.
     */

    public static Phi make() {
        return new BruteForcePhi();
    }
}
