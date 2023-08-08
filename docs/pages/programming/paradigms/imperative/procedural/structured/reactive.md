# Reactive Programming

---

## Table of Contents
<!-- TOC -->
* [Reactive Programming](#reactive-programming)
  * [Table of Contents](#table-of-contents)
  * [What's Reactive Programming](#whats-reactive-programming)
  * [Asynchronous vs Synchronous](#asynchronous-vs-synchronous)
    * [Thread Management in Synchronous Programming](#thread-management-in-synchronous-programming)
    * [Thread Management in Asynchronous Programming](#thread-management-in-asynchronous-programming)
  * [Example](#example)
  * [Languages](#languages)
  * [Ref.](#ref)
<!-- TOC -->

---


## What's Reactive Programming


Reactive programming is a programming paradigm that focuses on asynchronous data streams and the propagation of changes. It is often used to handle events and data flow in a more responsive and efficient manner, particularly in user interfaces and systems where events occur frequently.

At the core of reactive programming is the concept of `reactive streams`. A reactive stream represents a `sequence of events or data changes over time`. These events can be anything from user interactions, sensor readings, database updates, or any other asynchronous events. Reactive programming provides tools and abstractions to process, transform, and react to these events in a declarative and composable way.

<sub>[Back to top](#table-of-contents)</sub>


## Asynchronous vs Synchronous

- **Asynchronous**: Reactive programming is well-suited for handling asynchronous operations and real-time data, making it particularly useful for scenarios where events occur frequently and in an unpredictable manner

- **Synchronous**: Imperative programming typically follows a synchronous execution model, where each operation is executed in sequence, waiting for the previous one to complete before moving on to the next.

<sub>[Back to top](#table-of-contents)</sub>


### Thread Management in Synchronous Programming
**Synchronous** programming typically involves a linear flow of execution, where each operation is executed one after the other in a sequential manner. In the context of thread management, this means that a single thread of execution is used to carry out all tasks and operations. If one operation blocks (e.g., waiting for I/O or a resource), the entire thread is blocked, and no other tasks can be performed until the blocking operation completes.

For example, in a synchronous programming model:

```python
print("Starting")
result = perform_synchronous_io()  # Blocking I/O operation
print("Result:", result)
print("Finished")
```

In this case, if `perform_synchronous_io()` blocks, the `entire thread is blocked`, and the program will not proceed until the I/O operation completes.

<sub>[Back to top](#table-of-contents)</sub>


### Thread Management in Asynchronous Programming
**Asynchronous** programming involves the use of multiple threads (or non-blocking event loops) to manage concurrent operations efficiently. In this model, when an operation blocks, the thread can be released to perform other tasks, allowing for better utilization of resources and improved responsiveness.

For example, in an asynchronous programming model:


```python
print("Starting")
async_result = perform_asynchronous_io()  # Non-blocking I/O operation
print("Continuing other work...")
result = await async_result
print("Result:", result)
print("Finished")
```

In this case, when perform_asynchronous_io() is called, the thread is not blocked, and other work can continue. The await keyword is used to pause the current execution until the asynchronous operation is complete.

>Asynchronous programming is particularly useful in scenarios where tasks can be performed concurrently, such as handling multiple network requests or responding to various user interactions in a responsive way.


![img.png](reactive-programming.png)

<sub>[Back to top](#table-of-contents)</sub>


## Example

Here's a basic demonstration of reactive programming using JavaScript and the RxJS library, which is a popular library for reactive programming:

```javascript
// Import the RxJS library
import { fromEvent } from 'rxjs';
import { map, filter, debounceTime } from 'rxjs/operators';

// Create an observable from a DOM element's click events
const button = document.getElementById('myButton');
const clickObservable = fromEvent(button, 'click');

// Use operators to transform and filter the stream
const transformedStream = clickObservable.pipe(
    debounceTime(300), // Wait for 300ms pause between clicks
    map(event => event.clientX), // Extract the x-coordinate of the click
    filter(x => x > 100) // Filter out clicks with x-coordinate less than 100
);

// Subscribe to the transformed stream to react to events
transformedStream.subscribe(x => {
    console.log('Clicked at x-coordinate:', x);
});
```

In this example:

- We create an observable from a DOM element's click events using the fromEvent function.

- We use operators like debounceTime, map, and filter to transform and filter the stream of click events.


- We subscribe to the transformed stream using the subscribe method to react to the events.


<sub>[Back to top](#table-of-contents)</sub>


## Languages

Several modern programming languages and frameworks are commonly used for reactive programming due to their strong support for asynchronous and event-driven programming paradigms. Some of the most popular ones include:

- **Java**: Java is widely used for reactive programming, especially with the introduction of the **Reactive Streams API** and libraries like **Project Reactor** and **Akka Streams**. Spring Framework also provides support for building reactive applications (**Spring WebFlux**).

<!--TODO:See also: [Reactive Programming in Java]()-->

- **JavaScript/TypeScript**: JavaScript is commonly used for building reactive web applications, especially with the rise of front-end libraries and frameworks like **React**, **Angular**, and **Vue.js**. **TypeScript**, a statically typed superset of JavaScript, is also widely adopted for building reactive systems.


- **Scala**: Scala is a language that runs on the **Java Virtual Machine (JVM)** and is known for its strong support of functional and concurrent programming. It is used with Akka, a popular toolkit for building reactive and distributed systems.


- **Kotlin**: Kotlin is another **JVM-based** language that has gained popularity for reactive programming, often used in conjunction with libraries like Project Reactor and Spring WebFlux.


- **Python**: While not traditionally associated with reactive programming, Python has gained support for asynchronous programming with features like the asyncio library, allowing developers to write reactive code.


- **Swift**: Swift, the language used for developing iOS and macOS applications, supports reactive programming with libraries like RxSwift and Combine.


- **C#**: C# has embraced reactive programming with the Reactive Extensions (Rx) library, which provides an elegant way to work with asynchronous data streams.


- **Elixir**: Elixir, a functional programming language built on the Erlang VM, is inherently designed for building highly concurrent, fault-tolerant, and reactive systems.


- **Go**: While not strictly reactive, Go (Golang) provides concurrency primitives like goroutines and channels that can be used to build reactive-like systems.


- **Rust**: Rust is known for its emphasis on safety and performance, and while not specifically designed for reactive programming, it can be used to build systems that manage asynchronous and concurrent operations effectively.


>Reactive programming allows you to easily compose and manipulate data streams while promoting a more responsive and efficient way of handling asynchronous events.


<sub>[Back to top](#table-of-contents)</sub>

___

## Ref.

- https://www.lightbend.com/white-papers-and-reports/reactive-programming-versus-reactive-systems
- https://www.baeldung.com/cs/reactive-programming
- 
___

[Get Started](../../../../../../get-started.md#paradigms)

---