# Declarative Programming

---

## Table of Contents
<!-- TOC -->
* [Declarative Programming](#declarative-programming)
  * [Table of Contents](#table-of-contents)
  * [What's Declarative Programming](#whats-declarative-programming)
  * [Characteristics](#characteristics)
  * [Languages](#languages)
  * [Example](#example)
  * [Declarative programming vs. imperative programming](#declarative-programming-vs-imperative-programming)
  * [Ref.](#ref)
<!-- TOC -->
---

## What's Declarative Programming

Declarative programming is a programming paradigm that focuses on describing *what should be accomplished rather than how it should be accomplished*. In declarative programming, you define the desired result or outcome, and the underlying implementation details are abstracted away. 


## Characteristics

- **High-Level Abstractions**: Declarative languages provide high-level abstractions that allow you to express complex operations and computations concisely. These abstractions are often closer to human-readable descriptions of the problem.


- **Focus on Relationships**: Declarative programs emphasize relationships between different parts of the code rather than explicit sequences of steps. You specify relationships, patterns, and constraints that the system should adhere to.


- **Delegated Execution**: The programming environment or runtime is responsible for executing the program efficiently. Developers do not need to manage low-level details of execution, like memory management or explicit control flow.


- **Implicit Control Flow**: In declarative programming, control flow is often handled implicitly. The order of execution is determined by the relationships and dependencies between components rather than by explicit instructions.


- **Conciseness and Readability**: Declarative code tends to be more concise and readable, as it focuses on expressing the intent of the code without getting bogged down in implementation details.


## Languages

- **SQL (Structured Query Language)**: Used for querying and manipulating relational databases. You specify the data you want to retrieve or manipulate, and the database engine handles the actual retrieval and manipulation.


- **HTML (Hypertext Markup Language)**: Used for structuring and presenting web content. You define the structure of the content and its presentation, and the web browser renders it accordingly.


- **Regular Expressions**: Used for pattern matching and manipulation of strings. You specify patterns that describe the desired text, and the regular expression engine handles the matching.


- **Functional Programming**: While not exclusively declarative, functional programming often emphasizes immutability, higher-order functions, and expressing computations in terms of function compositions, which can lead to a more declarative style.

  - See also: [Functional Programming](functional.md)

>Declarative programming can lead to code that is easier to reason about, maintain, and extend, especially in complex and data-intensive applications. However, it may not be suitable for all types of problems and may require a programming environment or language that supports the declarative paradigm.

## Example

```java
import java.util.stream.IntStream;

public class DeclarativeExample {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum: " + sum);
    }
}
```

In this example, we're using Java's Stream API to perform the summation 
*declaratively*. The `IntStream.rangeClosed(1, 10)` generates a stream of integers from 1 to 10 (inclusive), and the `sum()` operation calculates the sum of those numbers. This code expresses the desired outcome (calculating the sum) without specifying the step-by-step process of how to achieve it, which is characteristic of declarative programming.


<sub>[Back to top](#table-of-contents)</sub>


## Declarative programming vs. imperative programming
Declarative programming is a high-level programming concept, which is the opposite of imperative programming

Declarative programming relies on underlying components of a given language to carry out the necessary steps to reach the stated outcome. In declarative programming, typical programming constructs such as loops and if/then conditions do not exist, because they are **instructional**

- See also: [Imperative Programming](../imperative/imperative.md)

---

## Ref.

- https://www.techtarget.com/searchitoperations/definition/declarative-programming

---

[Get Started](../../../../get-started.md#paradigms)

---



