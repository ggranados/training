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

Functional programming treats computation as the evaluation of mathematical functions. It emphasizes **immutability**, **pure functions**, and avoiding **mutable state** and **side effects**. 

Functional programming focuses on expressing computations through the composition and transformation of functions.

Its main focus is on “what to solve” in contrast to an imperative style where the main focus is “how to solve” [^1]

<sub>[Back to top](#table-of-contents)</sub>

## FP Principles

### Pure Functions
A pure function **always produces the same output for the same input** and has no side effects on the program or the environment.

It does not modify any external state or variables and does not rely on any external mutable state.


```javascript
// Pure function
function add(a, b) {
  return a + b;
}
```

<sub>[Back to top](#table-of-contents)</sub>

### Immutable Data
Functional programming encourages the use of immutable data structures, where **data cannot be changed after creation**.

Instead of modifying data, new data is created with each operation, ensuring data integrity.

Example shows a new array called `newArray` being created by copying `originalArray`'s elements, and adding up element 4

```javascript
const originalArray = [1, 2, 3];
const newArray = [...originalArray, 4]; // Creating a new array with 4 added
```

<sub>[Back to top](#table-of-contents)</sub>

### Higher-Order Functions
Functions can take other **functions as arguments or return functions** as results.

Higher-order functions enable function composition and the creation of abstractions.

Example shows an **arrow function** multiplying num by 2 is being passed to `map` function, which will apply it to each element in numbers array.

```javascript
const numbers = [1, 2, 3];
const doubledNumbers = numbers.map(num => num * 2);
```

<sub>[Back to top](#table-of-contents)</sub>

### Function Composition
Functions can be composed by **chaining them together**, creating more complex behaviors from simpler functions.

The output of one function becomes the input of another.

Example shows a composed function called `addAndSquare`, being created by setting `add` function to `square` function as parameter, the passing it to new function

```javascript
const add = (a, b) => a + b;
const square = num => num * num;

const addAndSquare = (a, b) => square(add(a, b));
```

<sub>[Back to top](#table-of-contents)</sub>


### Recursion
Recursion is a fundamental concept in functional programming where a **function calls itself** to solve a problem.

It is used instead of iterative loops to achieve repetition.

Example shows recursive `factorial` function implementation, where it calls itself each time `n-1` until base case `n == 0` is reached 

```javascript
function factorial(n) {
  if (n === 0) return 1;
  return n * factorial(n - 1);
}
```

<sub>[Back to top](#table-of-contents)</sub>

### First-Class Functions
Functions are treated as **first-class citizens**, meaning they can be assigned to variables, passed as arguments, or returned from other functions.

  Example shows a function being set to `greet` variable, then executed in `console.log`, so it´s return will be passed as parameter 

```javascript
const greet = function(name) {
  return `Hello, ${name}!`;
};

console.log(greet("Alice")); // Output: "Hello, Alice!"

```

<sub>[Back to top](#table-of-contents)</sub>

## Examples

Here's an example in JavaScript that incorporates several functional programming principles, including pure functions, immutability, higher-order functions, function composition, and recursion

```javascript
// Pure Function - Add two numbers
const add = (a, b) => a + b;

// Immutable Data - Using spread operator to create new arrays
const numbers = [1, 2, 3];
const doubledNumbers = [...numbers, 4].map(num => num * 2);

// Higher-Order Function - Filter even numbers from an array
const isEven = num => num % 2 === 0;
const evenNumbers = numbers.filter(isEven);

// Function Composition - Composing functions to get the total sum of even numbers
const sum = arr => arr.reduce((acc, curr) => acc + curr, 0);
const totalSumOfEvenNumbers = sum(evenNumbers);

// Recursion - Calculate the factorial of a number using recursion
const factorial = n => {
  if (n === 0) return 1;
  return n * factorial(n - 1);
};

// Output the results
console.log("Addition:", add(2, 3)); // Output: 5
console.log("Doubled Numbers:", doubledNumbers); // Output: [2, 4, 6, 8]
console.log("Even Numbers:", evenNumbers); // Output: [2]
console.log("Total Sum of Even Numbers:", totalSumOfEvenNumbers); // Output: 2
console.log("Factorial of 5:", factorial(5)); // Output: 120

```

<sub>[Back to top](#table-of-contents)</sub>


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
  - Visit: [FP in Java](../languages/java/fp.md)
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

[^1]: https://www.geeksforgeeks.org/functional-programming-paradigm/

---

[Get Started](../../../get-started.md) 

---
