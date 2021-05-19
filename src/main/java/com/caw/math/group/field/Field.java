package com.caw.math.group.field;

import com.caw.math.group.AdditionGroup;
import com.caw.math.group.MultiplicativeGroup;

/**
 * An extension of both an {@link AdditionGroup} and a {@link MultiplicativeGroup} that supports the following
 * properties:
 *
 * 1. The elements of the field form an addition group with an additive neutral element of zero.
 * 2. The elements of the field form a multiplicative group with a multiplicative neutral element of one.
 * 3. The law of distribution holds i.e. a(b + c) = ab + ac
 *
 * @param <E>
 *     The field element type contained in this field.
 *
 * @author cwhitmore
 */

public interface Field<E extends FieldElement> extends AdditionGroup<E>, MultiplicativeGroup<E> {

}
