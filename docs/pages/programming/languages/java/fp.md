# FP in Java

---

## Table of Contents

<!-- TOC -->
* [FP in Java](#fp-in-java)
  * [Table of Contents](#table-of-contents)
  * [How is FP implemented in Java?](#how-is-fp-implemented-in-java)
      * [- Visit: Java 8](#--visit-java-8)
  * [Lambda Expressions](#lambda-expressions)
      * [- Visit: Lambda Expression](#--visit-lambda-expression)
  * [Functional Interfaces](#functional-interfaces)
      * [- Visit: Functional Interfaces](#--visit-functional-interfaces)
      * [- Visit: Method References](#--visit-method-references)
  * [Built-in Functional Interfaces](#built-in-functional-interfaces)
      * [- Visit: Built-in Functional Interfaces](#--visit-built-in-functional-interfaces)
  * [Streams API](#streams-api)
  * [Ref.](#ref)
<!-- TOC -->

## How is FP implemented in Java?

Java introduced functional programming features with the release of [Java 8](versions.md#java-8-lts) in March 2014.

#### - Visit: [Java 8](versions.md#java-8-lts)

Functional programming is a programming paradigm that treats computation as the evaluation of mathematical functions and avoids changing state and mutable data. 

Java implemented functional programming features primarily through the addition of **lambda expressions** and **functional interfaces**. 

<sub>[Back to top](#table-of-contents)</sub>


## Lambda Expressions
Lambda expressions are anonymous functions that allow you to treat functionality as a method argument, or even as a return value. 

They provide a concise way to express behavior that can be passed around, making it easier to write code in a functional style. 

The syntax of a lambda expression is as follows:

```java
(parameters) -> expression
```

For example, a simple lambda expression that adds two numbers would look like this:

```java
(int a, int b) -> a + b
```

#### - Visit: [Lambda Expression](java-8/lamda-expression.md)

<sub>[Back to top](#table-of-contents)</sub>

## Functional Interfaces

Functional interfaces are interfaces that have **exactly one abstract** method. 

Java 8 introduced the `@FunctionalInterface` annotation, which can be used to explicitly declare an interface as a functional interface. This annotation ensures that the interface has only one abstract method, preventing accidental addition of extra abstract methods. 

**Lambdas** and **method references** are used to implement the abstract method of functional interfaces.

For example:

```java

@FunctionalInterface
interface MyFunction {
    int apply(int x, int y);
}
```

#### - Visit: [Functional Interfaces](java-8/functional-interfaces.md)
#### - Visit: [Method References](java-8/method-references.md)

<sub>[Back to top](#table-of-contents)</sub>

## Built-in Functional Interfaces
Java 8 introduced a set of built-in functional interfaces in the `java.util.function` package. 

These interfaces cover common functional use cases, such as `Function`, `Predicate`, `Consumer`, and `Supplier`, among others. They provide a standard way of writing functional-style code without the need to create custom functional interfaces for every use case.

Here's an example using the Function interface:

```java
import java.util.function.Function;

public class FunctionalProgrammingExample {
  public static void main(String[] args) {
    Function<Integer, Integer> incrementByOne = x -> x + 1;
    System.out.println(incrementByOne.apply(5)); // Output: 6
  }
}
```

#### - Visit: [Built-in Functional Interfaces](java-8/built-in-functional-interfaces.md)

<sub>[Back to top](#table-of-contents)</sub>

## Streams API

Java 8 also introduced the Stream API, which allows you to perform aggregate operations on collections in a functional style. 

Streams provide a way to process data in a declarative manner, expressing the desired behavior rather than the step-by-step instructions.

Here's a simple example of using the Stream API to filter and sum a list of numbers:

```java
import java.util.Arrays;
import java.util.List;

public class StreamsExample {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                        .filter(x -> x % 2 == 0)
                        .mapToInt(x -> x)
                        .sum();

        System.out.println(sum); // Output: 6
    }
}
```

These functional programming features added in Java 8 and subsequent versions make it easier to write concise, expressive, and more readable code using functional constructs. They are a significant step towards supporting functional programming paradigms in the Java language.

<sub>[Back to top](#table-of-contents)</sub>

---

## Ref.

https://www.baeldung.com/java-8-lambda-expressions-tips
https://www.baeldung.com/java-8-functional-interfaces

___

[Get Started](../../../../get-started.md) |
[Back to top](#table-of-contents)

___



