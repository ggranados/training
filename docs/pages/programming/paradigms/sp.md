# Structured Programming

---

## Table of Contents
<!-- TOC -->
* [Structured Programming](#structured-programming)
  * [Table of Contents](#table-of-contents)
  * [Structured programming is a programming paradigm that aims to improve the clarity, maintainability, and efficiency of code by enforcing a set of structured control flow constructs. It advocates for the use of structured control flow statements like loops and conditionals to create well-organized and readable code.](#structured-programming-is-a-programming-paradigm-that-aims-to-improve-the-clarity-maintainability-and-efficiency-of-code-by-enforcing-a-set-of-structured-control-flow-constructs-it-advocates-for-the-use-of-structured-control-flow-statements-like-loops-and-conditionals-to-create-well-organized-and-readable-code)
  * [Examples](#examples)
  * [Languages](#languages)
  * [Ref.](#ref)
<!-- TOC -->


## Structured programming is a programming paradigm that aims to improve the clarity, maintainability, and efficiency of code by enforcing a set of structured control flow constructs. It advocates for the use of structured control flow statements like loops and conditionals to create well-organized and readable code.

Key principles of structured programming include:

- Sequential Execution: Code is executed in a linear, top-down order, with one statement following another.

- Selection (Conditionals): The use of conditional statements, such as if-else and switch-case, to make decisions based on certain conditions.

- Iteration (Loops): The use of loop statements, such as for, while, and do-while, to repeat a block of code until a certain condition is met.

By following these principles, structured programming promotes code that is easier to understand, debug, and modify.

## Examples

In this example, the program asks for user input, performs conditional checks, and uses a while loop to demonstrate sequential execution, selection, and iteration:

Sequential Execution: The program executes statements sequentially from top to bottom. It starts by asking for the user's name, welcoming the user, then proceeds to ask for the user's age.

Selection (Conditionals): The program uses an if-else statement to check the age of the user. If the age is greater than or equal to 18, it prints a message indicating eligibility to vote; otherwise, it prints a different message.

Iteration (Loops): The program uses a while loop to repeat a block of code five times. It prints the current count value and increments the count variable in each iteration.

```python
# Sequential Execution
name = input("Enter your name: ")
print("Welcome, " + name + "!")

# Selection (Conditionals)
age = int(input("Enter your age: "))
if age >= 18:
    print("You are eligible to vote.")
else:
    print("You are not eligible to vote yet.")

# Iteration (Loops)
count = 1
while count <= 5:
    print("Count: " + str(count))
    count += 1

print("Loop finished.")

```

By structuring the code in this way, it becomes more organized, easier to follow, and simpler to modify or add new functionality. The use of sequential execution, selection, and iteration helps in creating robust and maintainable codebases.


<sub>[Back to top](#table-of-contents)</sub>



## Languages

- C
- Pascal
- Ada
- Modula-2
- PL/I
- [Java](../../programming/languages/java)
- C++
- Python
- C#
- Ruby
- Swift
- Go
- Kotlin
- Rust
- Lua
- Perl
- JavaScript
- TypeScript
- PHP
- R

<sub>[Back to top](#table-of-contents)</sub>


---

## Ref.

- https://en.wikipedia.org/wiki/Structured_programming

---

[Get Started](../../common/get-started.md)

---
