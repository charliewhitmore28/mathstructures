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

GaloisPolynomialField (Bitwise Arithmetic)

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


## License
[MIT](https://choosealicense.com/licenses/mit/)
