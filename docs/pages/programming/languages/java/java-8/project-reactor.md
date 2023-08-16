# Reactor Core

---

## Table of Contents
<!-- TOC -->
* [Reactor Core](#reactor-core)
  * [Table of Contents](#table-of-contents)
  * [Dependencies](#dependencies)
    * [Maven](#maven)
    * [Gradle](#gradle)
    * [Log Dependencies](#log-dependencies)
  * [Reactive Data Types](#reactive-data-types)
    * [Flux](#flux)
    * [Mono](#mono)
  * [Producing a Stream of Data](#producing-a-stream-of-data)
    * [Using Flux](#using-flux)
    * [Using Mono](#using-mono)
  * [Why Not Only Flux?](#why-not-only-flux)
  * [Subscribing to a Stream](#subscribing-to-a-stream)
    * [Collecting Elements](#collecting-elements)
    * [The Flow of Elements](#the-flow-of-elements)
    * [Comparison to Java 8 Streams](#comparison-to-java-8-streams)
  * [Backpressure](#backpressure)
  * [Operating on a Stream](#operating-on-a-stream)
    * [Combining Two Streams](#combining-two-streams)
  * [Hot Streams](#hot-streams)
    * [Creating a ConnectableFlux](#creating-a-connectableflux)
    * [Throttling](#throttling)
  * [Concurrency](#concurrency)
  * [Ref.](#ref)
<!-- TOC -->

---

Reactor is a fourth-generation reactive library, based on the `Reactive Streams` specification, for building non-blocking applications on the JVM

>Reactor 3 requires Java 8 or + to run

<sub>[Back to top](#table-of-contents)</sub>


## Dependencies
### Maven
```xml
<dependency>
    <groupId>io.projectreactor</groupId>
    <artifactId>reactor-core</artifactId>
    <version>3.5.9</version>
</dependency>
```

<sub>[Back to top](#table-of-contents)</sub>

### Gradle
```groovy
dependencies {
    compile "io.projectreactor:reactor-core:3.5.9"
}
```

### Log Dependencies
We're also adding Logback as a dependency. This is because we'll be logging the output of the Reactor in order to better understand the flow of data. 

```xml
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.4.8</version>
</dependency>
```

```groovy
dependencies {
    implementation 'ch.qos.logback:logback-classic:1.4.8'
}
```


<sub>[Back to top](#table-of-contents)</sub>

## Reactive Data Types
Reactive Core gives us two data types that enable us to produce a stream of data, `Flux` and `Mono`.

In Project Reactor, `Flux` and `Mono` are examples of Publishers. They represent streams of data that emit elements or signals over time.

Both, `Flux` and `Mono` are implementations of the **Reactive Streams** `Publisher` interface. Both classes are compliant with the specification, and we could use this interface in their place:

```java
Publisher<String> just = Mono.just("foo");
```


<sub>[Back to top](#table-of-contents)</sub>


### Flux

- `Flux` is used to represent a stream of *zero to many elements* (0-n).


- It is similar to a collection, but it's designed to handle asynchronous and non-blocking scenarios.


- A `Flux` can emit any number of items over time, including zero items.


- It supports various reactive operations like *transformation*, *filtering*, *mapping*, *combining*, and more.


- Examples of sources for creating a `Flux` include *lists*, *arrays*, *generators*, *intervals*, and more.


<sub>[Back to top](#table-of-contents)</sub>


### Mono
- `Mono` is used to represent a stream of zero or one element.


- It is conceptually similar to an `Optional` in Java, but it's designed for reactive and asynchronous use cases.


- A `Mono` can emit either a single item or no item at all (an empty signal) (0-1).


- It is often used for representing the outcome of an asynchronous operation, such as a database query or a network call.


- Like `Flux`, `Mono` also supports various reactive operations.

<sub>[Back to top](#table-of-contents)</sub>

## Producing a Stream of Data
In order for an application to be reactive, the first thing it must be able to do is to produce a stream of data.

Without this data, we wouldn't have anything to react to

<sub>[Back to top](#table-of-contents)</sub>

### Using Flux

- #### Flux.just()
    You can create a `Flux` that emits a predefined sequence of values using the `Flux.just()` method.
    
    ```java
    import reactor.core.publisher.Flux;
    
    public class FluxDemo {
        public static void main(String[] args) {
            Flux<String> flux = Flux.just("apple", "banana", "cherry", "date");
    
            flux.subscribe(System.out::println);
        }
    }
    ```

<sub>[Back to top](#table-of-contents)</sub>


- #### Flux.fromIterable()
    You can create a `Flux` from an existing iterable, such as a list or a collection.
    
    ```java
    import reactor.core.publisher.Flux;
    import java.util.Arrays;
    import java.util.List;
    
    public class FluxDemo {
        public static void main(String[] args) {
            List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date");
            Flux<String> flux = Flux.fromIterable(fruits);
    
            flux.subscribe(System.out::println);
        }
    }
    ```


<sub>[Back to top](#table-of-contents)</sub>

- #### Flux.generate()
    You can generate a stream of data using a custom stateful generator function.
    
    ```java
    import reactor.core.publisher.Flux;
    
    public class FluxDemo {
        public static void main(String[] args) {
            Flux<Integer> flux = Flux.generate(
                    () -> 0,
                    (state, sink) -> {
                        sink.next(state);
                        if (state == 5) {
                            sink.complete();
                        }
                        return state + 1;
                    }
            );
    
            flux.subscribe(System.out::println);
        }
    }
    ```

  - `Flux.generate(state,generator)`: Creates a Flux using the generate method. The generate method takes two arguments: an *initial state* (provided by a supplier) and a generator function (`BiFunction`). The *generator function generates values and provides them to the sink* while maintaining some state.

  - `() -> 0`: This is the initial state supplier. It returns an initial state of 0.

  - `(state, sink) -> {}`: This is the generator function. It takes the current state and a sink as its arguments. *The sink is used to emit values, signals, and control the flow of the `Flux`*.

  - `sink.next(state)`: Emits the current state value through the sink.

  - `if (state == 5) { sink.complete(); }`: Checks if the current state is equal to 5. If so, it completes the Flux by calling `sink.complete()`. This *ensures that the stream terminates* after emitting the value 5.

  - `return state + 1`: Updates the state for the next iteration by incrementing it.


<sub>[Back to top](#table-of-contents)</sub>


- #### Flux.interval()
    You can create a stream that emits elements at a regular interval.

    ```java
    import reactor.core.publisher.Flux;
    import java.time.Duration;
    
    public class FluxDemo {
        public static void main(String[] args) {
            Flux<Long> flux = Flux.interval(Duration.ofSeconds(1));
    
            flux.subscribe(System.out::println);
    
            // Sleep for a while to allow some emissions
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    ```


<sub>[Back to top](#table-of-contents)</sub>

- #### Flux.range()
    You can create a stream that emits a range of integers.
    
    ```java
    import reactor.core.publisher.Flux;
    
    public class FluxDemo {
        public static void main(String[] args) {
            Flux<Integer> flux = Flux.range(1, 5);
    
            flux.subscribe(System.out::println);
        }
    }
    ```

<sub>[Back to top](#table-of-contents)</sub>

### Using Mono

`Mono` is typically used for producing a stream of zero or one element in **Project Reactor**. While it might not seem as common as using `Flux`, there are still scenarios where you would use `Mono` to represent a single result or outcome.

<sub>[Back to top](#table-of-contents)</sub>

- #### Mono.just()
    You can create a `Mono` that emits a single value using the Mono.just() method.

    ```java
    import reactor.core.publisher.Mono;
    
    public class MonoDemo {
        public static void main(String[] args) {
            Mono<String> mono = Mono.just("Hello, world!");
    
            mono.subscribe(System.out::println);
        }
    }
    ```


<sub>[Back to top](#table-of-contents)</sub>

- #### Mono.empty()
    You can create an empty `Mono` that doesn't emit any value. This is useful for representing the absence of a result.
    
    ```java
    import reactor.core.publisher.Mono;
    
    public class MonoDemo {
    public static void main(String[] args) {
    Mono<Object> emptyMono = Mono.empty();
    
            emptyMono.subscribe(
                value -> System.out.println("Received value: " + value),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Completed")
            );
        }
    }
    ```


<sub>[Back to top](#table-of-contents)</sub>

- #### Mono.defer()
    You can use `Mono.defer()` to create a `Mono` that is generated on each subscription. This can be useful when you want to create a new instance of `Mono` with potentially different behavior for each subscriber.
    
    ```java
    import reactor.core.publisher.Mono;
    
    public class DynamicMonoDemo {
        public static void main(String[] args) {
            // Create a supplier that generates a Mono with a random number
            Mono<Integer> dynamicMono = Mono.defer(() -> Mono.just((int) (Math.random() * 100)));
    
            // Subscribe and print a different random number on each subscription
            dynamicMono.subscribe(value -> System.out.println("Subscriber 1: " + value));
            dynamicMono.subscribe(value -> System.out.println("Subscriber 2: " + value));
        }
    }
    ```

    In the current code there's no practical difference between using `Mono.defer(() -> Mono.just((int) (Math.random() * 100)))` and simply using `Mono.just((int) (Math.random() * 100)))` directly, but there is a subtle but important difference between them:

  - **Using Mono.just() directly**:
    ```java
    Mono<Integer> dynamicMono = Mono.just((int) (Math.random() * 100));
    ```
    In this version, you are creating a single Mono instance that generates a random number between 0 and 100 at the time of creation. This random number is then emitted to all subscribers of this single Mono. Both subscribers will receive the same random value because the Mono emits the value only once when it is created.

  - **Using Mono.defer()**:
    ```java
    Mono<Integer> dynamicMono = Mono.defer(() -> Mono.just((int) (Math.random() * 100)));
    ```
    In this version, you are using Mono.defer() to create a new Mono instance for each subscription. Each time a subscriber subscribes to dynamicMono, the lambda inside Mono.defer() is executed, resulting in a new random value being generated and emitted separately for each subscriber. As a result, each subscriber receives a different random value. 



<sub>[Back to top](#table-of-contents)</sub>
    

- #### Mono.fromSupplier()
    You can create a `Mono` from a supplier function that provides the value to be emitted.
    
    ```java
    import reactor.core.publisher.Mono;
    
    public class MonoDemo {
        public static void main(String[] args) {
            Mono<String> mono = Mono.fromSupplier(() -> "Value from supplier");
    
            mono.subscribe(System.out::println);
        }
    }
    ```

<sub>[Back to top](#table-of-contents)</sub>


- #### Mono.fromCallable()
    You can create a `Mono` from a callable that represents a potentially blocking operation.
    
    ```java
    import reactor.core.publisher.Mono;
    
    public class MonoDemo {
        public static void main(String[] args) {
            Mono<Integer> mono = Mono.fromCallable(() -> {
                // Simulate a potentially blocking operation
                Thread.sleep(1000);
                return 42;
            });
    
            mono.subscribe(System.out::println);
        }
    }
    ```

<sub>[Back to top](#table-of-contents)</sub>

## Why Not Only Flux?

You might wonder why you shouldn't just use Flux for all cases. After all, Flux can represent zero, one, or multiple elements, which seems to cover all possibilities. However, there are reasons to use Mono in certain situations:

- **Semantic Clarity**: Using `Mono` when you expect at most one result or outcome can make your *code more semantically clear*.


- **Error Handling**: *In a `Mono`, errors terminate the stream immediately*, while in a `Flux`, other items can still be emitted after an error.


- **Synchronization and Composition**: In some scenarios, you might need to wait for a single result before proceeding with subsequent operations. Using `Mono` allows for *clear synchronization points* and more straightforward composition in such cases.


- **Resource Management**: When dealing with resources that need explicit management, such as connections or files, a `Mono` can be a better fit. It *ensures that the resource is released promptly after it's no longer needed*.


- **Backpressure Considerations**: If you're working with downstream systems that are sensitive to backpressure (*rate at which data is consumed*), using `Mono` ensures a strict *one-on-one relationship without the complexity of backpressure management* that comes with `Flux`.


- **API Contract**: Some libraries and APIs might expect or return `Mono` instances for certain operations.


>While Flux is more versatile and can handle a wide range of scenarios, using Mono when appropriate can lead to clearer and more maintainable code.

<sub>[Back to top](#table-of-contents)</sub>


## Subscribing to a Stream
Subscribing to a stream in Project Reactor is quite straightforward. The `subscribe()` method is used to initiate the subscription and start processing the data emitted by the stream

<sub>[Back to top](#table-of-contents)</sub>

### Collecting Elements
```java
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
        .log()
        .subscribe(elements::add);

        assertThat(elements).containsExactly(1, 2, 3, 4);
```

<sub>[Back to top](#table-of-contents)</sub>

### The Flow of Elements
With logging in place, we can use it to visualize how the data is flowing through our stream:

```bash
20:25:19.550 [main] INFO  reactor.Flux.Array.1 - | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | request(unbounded)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | onNext(1)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | onNext(2)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | onNext(3)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | onNext(4)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | onComplete()
```

- `onSubscribe()` – This is called when we subscribe to our stream


- `request(unbounded)` – When we call subscribe, behind the scenes we are creating a `Subscription`. This subscription requests elements from the stream. In this case, it defaults to unbounded, meaning it requests every single element available


- `onNext()` – This is called on every single element


- `onComplete()` – This is called last, after receiving the last element. There's actually an onError() as well, which would be called if there is an exception, but in this case, there isn't

This is the flow laid out in the Subscriber interface as part of the Reactive Streams Specification, and in reality, that's what's been instantiated behind the scenes in our call to `onSubscribe()`. It's a useful method, but to better understand what's happening let's provide a Subscriber interface directly:

```java
List<Integer> elements = new ArrayList<>();

  Flux.just(1, 2, 3, 4)
    .log()
    .subscribe(new Subscriber<Integer>() {
        
        @Override
        public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
                }
        
        @Override
        public void onNext(Integer integer) {
                logger.info("Consuming item: {}", integer);
                elements.add(integer);
                }
        
        @Override
        public void onError(Throwable t) {
                logger.error("An error occurred: {}", t.getCause());
                }
        
        @Override
        public void onComplete() {
                logger.info("Data stream complete");
                }
        });

        logger.info(elements.toString());
```

Output:
```bash
2023-08-17 17:22:03 INFO  reactor.Flux.Array.1 - | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
2023-08-17 17:22:03 INFO  reactor.Flux.Array.1 - | request(unbounded)
2023-08-17 17:22:03 INFO  reactor.Flux.Array.1 - | onNext(1)
2023-08-17 17:22:03 INFO  c.e.r.ReactorDemoApplication - Consuming item:1
2023-08-17 17:22:03 INFO  reactor.Flux.Array.1 - | onNext(2)
2023-08-17 17:22:03 INFO  c.e.r.ReactorDemoApplication - Consuming item:2
2023-08-17 17:22:03 INFO  reactor.Flux.Array.1 - | onNext(3)
2023-08-17 17:22:03 INFO  c.e.r.ReactorDemoApplication - Consuming item:3
2023-08-17 17:22:03 INFO  reactor.Flux.Array.1 - | onNext(4)
2023-08-17 17:22:03 INFO  c.e.r.ReactorDemoApplication - Consuming item:4
2023-08-17 17:22:03 INFO  reactor.Flux.Array.1 - | onComplete()
2023-08-17 17:22:03 INFO  c.e.r.ReactorDemoApplication - Data stream complete
2023-08-17 17:22:03 INFO  c.e.r.ReactorDemoApplication - [1, 2, 3, 4]
```

>We can see that each possible stage in the above flow maps to a method in the Subscriber implementation. It just happens that Flux has provided us with a helper method to reduce this verbosity.

<sub>[Back to top](#table-of-contents)</sub>

### Comparison to Java 8 Streams

It might appear that we have something synonymous to a Java 8 Stream doing collect:

```java
List<Integer> collected = Stream.of(1, 2, 3, 4)
.collect(toList());
```

But we don't.

The core difference is that Reactive is a push model, whereas the Java 8 Streams are a pull model. In a reactive approach, *events are pushed to the subscribers as they come in*.

The next thing to notice is a Streams terminal operator is just that, terminal, pulling all the data and returning a result. With Reactive we could have an infinite stream coming in from an external resource, with multiple subscribers attached and removed on an ad hoc basis. We can also do things like _combine streams_, _throttle streams_, and apply _backpressure_

<sub>[Back to top](#table-of-contents)</sub>

## Backpressure
Backpressure is when a downstream can tell an upstream to send it less data in order to prevent it from being overwhelmed.

<sub>[Back to top](#table-of-contents)</sub>

## Operating on a Stream

We can also perform operations on the data in our stream

- ### map
This is a transformation operator. It takes an input element and applies a function to it, emitting a transformed element as output.

  ```java
import reactor.core.publisher.Flux;

public class MapExample {
  public static void main(String[] args) {
    Flux<Integer> numbers = Flux.range(1, 5);

    Flux<Integer> squaredNumbers = numbers.map(n -> n * n);

    squaredNumbers.subscribe(System.out::println);
  }
}
  ```

<sub>[Back to top](#table-of-contents)</sub>

- ### filter
This is a transformation operator. It filters the elements of the input stream based on a predicate and emits only the elements that satisfy the condition.

```java
import reactor.core.publisher.Flux;

public class FilterExample {
  public static void main(String[] args) {
    Flux<Integer> numbers = Flux.range(1, 5);

    Flux<Integer> evenNumbers = numbers.filter(n -> n % 2 == 0);

    evenNumbers.subscribe(System.out::println);
  }
}
```

<sub>[Back to top](#table-of-contents)</sub>

- ### flatMap
This is a transformation operator. It takes an input element and applies a function that returns a stream of output elements. The resulting output elements are then merged into a single output stream.

```java
import reactor.core.publisher.Flux;

public class FlatMapExample {
  public static void main(String[] args) {
    Flux<Integer> numbers = Flux.range(1, 3);

    Flux<Integer> doubledNumbers = numbers.flatMap(n -> Flux.just(n, n * 2));

    doubledNumbers.subscribe(System.out::println);
  }
}
```

<sub>[Back to top](#table-of-contents)</sub>

- ### reduce
This is a transformation operation that aggregates the elements of the input stream using an accumulator function, eventually emitting a single output element.

```java
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReduceExample {
  public static void main(String[] args) {
    Flux<Integer> numbers = Flux.range(1, 5);

    Mono<Integer> sum = numbers.reduce(0, (a, b) -> a + b);

    sum.subscribe(System.out::println);
  }
}
```

<sub>[Back to top](#table-of-contents)</sub>

### Combining Two Streams

- ### zipWith
Allows you to combine elements from two or more streams into pairs or tuples, emitting the combined result

```java
import reactor.core.publisher.Flux;

public class ZipWithExample {
  public static void main(String[] args) {
    Flux<Integer> stream1 = Flux.range(1, 5);
    Flux<Integer> stream2 = Flux.range(6, 5);

    Flux<Tuple2<Integer, Integer>> zippedStream = stream1.zipWith(stream2);

    zippedStream.subscribe(tuple -> System.out.println("Tuple: " + tuple));
  }
}
```

In this example, zipWith combines elements from `stream1` and `stream2` into tuples of two elements. Each tuple contains one element from `stream1` and one element from `stream2`. The resulting tuples are emitted in the `zippedStream`.

The output will be:

```bash
Tuple: (1, 6)
Tuple: (2, 7)
Tuple: (3, 8)
Tuple: (4, 9)
Tuple: (5, 10)
```

## Hot Streams

<sub>[Back to top](#table-of-contents)</sub>

### Creating a ConnectableFlux

### Throttling

## Concurrency



## Ref.

- https://projectreactor.io/
- https://github.com/reactor/reactor-core
- https://www.baeldung.com/reactor-core