# Functional Programming

---

## Table of Contents
<!-- TOC -->
* [Functional Programming](#functional-programming)
  * [Table of Contents](#table-of-contents)
  * [What's FP](#whats-fp)
  * [FP Principles](#fp-principles)
    * [Pure Functions](#pure-functions)
    * [Immutable Data](#immutable-data)
    * [Higher-Order Functions](#higher-order-functions)
    * [Function Composition](#function-composition)
    * [Recursion](#recursion)
    * [First-Class Functions](#first-class-functions)
  * [Examples](#examples)
  * [Languages](#languages)
    * [Pure Functional Programming Languages](#pure-functional-programming-languages)
    * [Non-Pure Functional Programming Languages:](#non-pure-functional-programming-languages)
  * [Ref.](#ref)
<!-- TOC -->


## What's FP

Functional programming treats computation as the evaluation of mathematical functions. It emphasizes immutability, pure functions, and avoiding mutable state and side effects. 

Functional programming focuses on expressing computations through the composition and transformation of functions.


<sub>[Back to top](#table-of-contents)</sub>

## FP Principles

### Pure Functions
A pure function always produces the same output for the same input and has no side effects on the program or the environment.

It does not modify any external state or variables and does not rely on any external mutable state.

```javascript
// Pure function
function add(a, b) {
  return a + b;
}
```

<sub>[Back to top](#table-of-contents)</sub>

### Immutable Data
Functional programming encourages the use of immutable data structures, where data cannot be changed after creation.

Instead of modifying data, new data is created with each operation, ensuring data integrity.

```javascript
const originalArray = [1, 2, 3];
const newArray = [...originalArray, 4]; // Creating a new array with 4 added
```

<sub>[Back to top](#table-of-contents)</sub>

### Higher-Order Functions
Functions can take other functions as arguments or return functions as results.

Higher-order functions enable function composition and the creation of abstractions.

```javascript
Functional programming encourages the use of immutable data structures, where data cannot be changed after creation.
Instead of modifying data, new data is created with each operation, ensuring data integrity.
```

<sub>[Back to top](#table-of-contents)</sub>

### Function Composition
Functions can be composed by chaining them together, creating more complex behaviors from simpler functions.

The output of one function becomes the input of another.

```javascript
const add = (a, b) => a + b;
const square = num => num * num;

const addAndSquare = (a, b) => square(add(a, b));
```

### Recursion
Recursion is a fundamental concept in functional programming where a function calls itself to solve a problem.

It is used instead of iterative loops to achieve repetition.

```javascript
Recursion is a fundamental concept in functional programming where a function calls itself to solve a problem.
It is used instead of iterative loops to achieve repetition.
```

<sub>[Back to top](#table-of-contents)</sub>

### First-Class Functions
Functions are treated as first-class citizens, meaning they can be assigned to variables, passed as arguments, or returned from other functions.

```javascript
const greet = function(name) {
  return `Hello, ${name}!`;
};

console.log(greet("Alice")); // Output: "Hello, Alice!"

```

<sub>[Back to top](#table-of-contents)</sub>

## Examples

The example is in Scala and demonstrates the use of a higher-order function map to transform a list of numbers by doubling each element

```scala
val numbers = List(1, 2, 3, 4, 5)
val doubledNumbers = numbers.map(_ * 2)
println(doubledNumbers)
```

## Languages
### Pure Functional Programming Languages

A pure functional programming language is a programming language that adheres strictly to the principles of functional programming

- Haskell
- Erlang
- Clojure
- Elm
- PureScript
- Miranda
- Idris

### Non-Pure Functional Programming Languages:

Non-pure functional programming languages combine functional programming concepts with other programming paradigms, such as object-oriented programming or imperative programming. These languages provide support for functional programming features but also allow for mutable state, side effects, and imperative constructs.

- Java (with the addition of lambda expressions and the Stream API in Java 8)
- JavaScript (with functional programming libraries like Ramda and lodash-fp)
- Scala
- F#
- OCaml
- Lisp (including Common Lisp and Scheme dialects)
- Racket
- Elixir



<sub>[Back to top](#table-of-contents)</sub>


---

## Ref.

---

[Get Started](../../../get-started.md) 

---
