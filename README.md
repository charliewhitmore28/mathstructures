# Math Structures

MathStructures is a library intended to provide math algorithms and data structures useful for mathematical exploration.

## Installation

Coming soon!

## Features

### Galois Fields

Two types of galois fields can be utilized through this library, the GaloisPrimeField and the GaloisPolynomialField
that support basic math operations. Elements inside of the two types of fields are represented as GaloisElement objects
that also support basic math oeprations.

- add
- additiveInverseOf
- divide
- multiplicativeInverseOf
- multiply
- subtract

GaloisPrimeField

```java
final GaloisPrimeField field = new GaloisPrimeField(7);
final GaloisElement product = field.multiply(4, 4);
System.out.println(product.value()); // 2
```

In order to perform galois polynomial arithmetic, an irreducible polynomial must be supplied to the galois polynomial field.
Some sample irreducible polynomials can be found underneath src/main/resources/irreducibles for various field sizes.
The value of an irreducible polynomial (or any polynomial element) is equal to 
(coefficient) * (prime) ^ (degree) + ... for each polynomial element.

For example, in GF(2^8), a typical irreducible polynomial is
x^8 + x^4 + x^3 + x + 1 which has a value of 
2^8 + 2^4 + 2^3 + 2^1 + 2^0 = 256 + 16 + 8 + 2 + 1 = 283.
In GF(5^8), a simple example of an irreducible polynomial is x^8 + 2 = 5^8 + 2 (390,627).
A good source of examples is the test classes included in this project, which 
use a number of different fields, and have some by-hand validation in the comments. 

Note: there is currently no internal validation that a supplied value corresponds to a valid irreducible polynomial
for that field size.  If a reducible polynomial is supplied - the arithmetic may have undefined behavior (not all elements will have an inverse, etc.).

GaloisPolynomialField (Bitwise Arithmetic). Significantly faster but this implementation is only able to be used when the galois
field has a prime value of two.

```java
final GaloisPolynomialField field = new GaloisPolynomialField(2, 8, 283);
final GaloisElement product = field.multiply(75, 34);
System.out.println(product.value()); // 53
```

GaloisPolynomialField (Non-Bitwise)

```java
final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
final GaloisElement product = field.multiply(121_212, 212_121);
System.out.println(product.value()); // 133_131
```

GaloisElement

```java
final GaloisPolynomialField field = new GaloisPolynomialField(5, 8, 390_627);
final GaloisElement multiplicand = field.element(121_212);
final GaloisElement product = multiplicand.multiply(212_121);
System.out.println(product.value()); // 133_131
```

### Integer Rings

The IntegerRing is implemented as a Group that supports the addition operations only, and as such does not support 
multiplicative operations (multiply, divide, multiplicativeInverseOf, etc.), but as a result you are able to construct
Integer Rings of non-prime size, which differentiates it from a GaloisPrimeField.

- add
- additiveInverseOf
- subtract

Similar to the GaloisField implementations, IntegerRing arithmetic can be invoked on the IntegerRing
itself, or on the IntegerRingElements inside the IntegerRing. Examples can be found in the test classes.

```java
final IntegerRing ring = new IntegerRing(12);
final IntegerRingElement sum = ring.add(7, 8);
System.out.println(sum.value()); // 3
```

```java
final IntegerRing ring = new IntegerRing(100);
final IntegerRingElement minuend = ring.element(50);
final IntegerRingElement difference = minuend.subtract(67);
System.out.println(difference.value()); // 83
```

```java
final IntegerRing ring = new IntegerRing(15);
final BigInteger phi = ring.phi();
System.out.println(phi); // 8
```

## License
[MIT](https://choosealicense.com/licenses/mit/)
