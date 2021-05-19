package com.caw.math.group.field.galois;

import com.caw.math.model.polynomial.ModularPolynomial;
import com.caw.math.model.polynomial.ModularPolynomialFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO:: I would really like a fast, memory-efficient way of calculating irreducible polynomials. This class can be used to generate all
 * TODO:: the irreducible polynomials for a galois field, however for galois fields with large primes or prime powers
 * TODO:: this solution is at best inefficient and at worst infeasible. For example, GF(5^8) already has 195,000
 * TODO:: irreducible polynomials. For this reason, I've left this class here as a quick way to get some sample
 * TODO:: irreducibles for testing but I've left out any sort of irreducible verification or the ability to randomly
 * TODO:: generate an irreducible as it would create an arbitrary bottleneck on the size of fields we could support.
 *
 * @author cwhitmore
 */

// Deprecate and suppress all - throwaway class
@Deprecated
@SuppressWarnings("PMD")
public final class IrreduciblePolynomials {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            cacheIrreducibles(BigInteger.valueOf(7), i);
        }
    }

    /**
     * Generate a file in src/main/resources with the irreducible polynomials corresponding to a galois field with
     * the specified {@code prime} and {@code primePower}.
     */

    @SuppressWarnings("unused")
    private static void cacheIrreducibles(final BigInteger prime, final int primePower) {

        final List<BigInteger> sorted = irreduciblesOf(prime, primePower).stream()
                .sorted()
                .collect(Collectors.toList());

        // Let's store the polynomial Strings for user readability. Delete this later if file system space ends up
        // being a constraint, although at that point - this is just not a feasible design anyway.
        final List<ModularPolynomial> modularPolynomials = sorted.stream()
                .map(i -> ModularPolynomialFactory.fromValue()
                        .withValue(i)
                        .withModulus(prime)
                        .build()).collect(Collectors.toList());

        final String path = "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + "irreducibles" + File.separator + prime;
        final String file = "irreducibles_" + prime + "_" + primePower + ".txt";

        final File directory = new File(path);
        if (directory.mkdirs()) {
            System.out.println("Creating directory: path=" + path);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + File.separator + file))) {

            for (final ModularPolynomial poly : modularPolynomials) {
                bw.write(poly.value() + " (" + poly + ")");
                bw.newLine();
            }

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculate all of the irreducible polynomials for the specified {@code prime} and {@code primePower} using
     * brute force.
     */

    public static Set<BigInteger> irreduciblesOf(final BigInteger prime, final int primePower) {

        if (primePower < 0) {
            throw new IllegalArgumentException("Invalid parameter: primePower=" + primePower);
        }
        final Set<BigInteger> irreducibles = new HashSet<>();

        if (primePower == 0) {
            irreducibles.add(BigInteger.ONE);
            return irreducibles;
        }

        if (primePower == 1) {
            irreducibles.add(BigInteger.valueOf(2));
            irreducibles.add(BigInteger.valueOf(3));
            return irreducibles;
        }

        final Set<BigInteger> reducibles = reduciblesOf(prime, primePower);

        final BigInteger floor = prime.pow(primePower);
        final BigInteger ceiling = prime.pow(primePower + 1);

        return Stream.iterate(floor, bi -> bi.add(BigInteger.ONE))
                .limit(ceiling.subtract(floor).longValueExact())
                .filter(bi -> !reducibles.contains(bi))
                .collect(Collectors.toSet());
    }

    /**
     * Calculate all of the reducible polynomials for a specified {@code prime} and {@code primePower} using brute force.
     */

    private static Set<BigInteger> reduciblesOf(final BigInteger prime, final int primePower) {

        final Set<BigInteger> reducibles = new HashSet<>();

        for (int currentDegree = primePower / 2; currentDegree < primePower; currentDegree++) {

            final BigInteger floor1 = prime.pow(currentDegree);
            final BigInteger ceiling1 = prime.pow(currentDegree + 1);

            final BigInteger floor2 = prime.pow(primePower - currentDegree);
            final BigInteger ceiling2 = prime.pow(primePower - currentDegree + 1);

            for (BigInteger i = floor1; i.compareTo(ceiling1) < 0; i = i.add(BigInteger.ONE)) {
                for (BigInteger j = floor2; j.compareTo(ceiling2) < 0; j = j.add(BigInteger.ONE)) {
                    final ModularPolynomial modularPolynomial = ModularPolynomialFactory.fromValue()
                            .withValue(i)
                            .withModulus(prime)
                            .build();
                    reducibles.add(modularPolynomial.multiply(j).value());
                }
            }
        }

        return reducibles;
    }
}
