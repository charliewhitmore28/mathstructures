package com.caw.math.group;

/**
 * An extension of {@link Group} that in addition to the standard properties of a {@code Group}, is also commutative.
 *
 * @author cwhitmore
 */

public interface AbelianGroup<E extends AbelianGroupElement> extends Group<E> {
}
