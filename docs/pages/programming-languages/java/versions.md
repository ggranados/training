# Main Java Version Changes 

All language features from Java 8 serve as very good Java base knowledge and everything else (Java 9-20) is pretty much additional features on top of that baseline

## Table of Contents
1. [Java 1](#java-1)
2. [Java 1.1](#java-11)
3. [Java 1.2](#java-12)
4. [Java 1.3](#java-13)
5. [Java 1.4](#java-14)
6. [Java 5](#java-5)
7. [Java 6](#java-6)
8. [Java 7](#java-7)
9. [Java 8](#java-8)
10. [Java 9](#java-9)
11. [Java 10](#java-10)
12. [Java 11](#java-11-1)
13. [Java 12](#java-12-1)
14. [Java 13](#java-13-1)
15. [Java 14](#java-14-1)
16. [Java 15](#java-15)
17. [Java 16](#java-16)
18. [Java 17](#java-17)
19. [Java 18](#java-18)
20. [Java 19](#java-19)
21. [Java 20](#java-20)
22. [Java 21](#java-21)

___

## Java 1
(released in January 1996)

- The first stable version

<sub>[Back to top](#table-of-contents)</sub>

## Java 1.1
(released in February 1997)

- AWT event model
- Inner classes
- JavaBeans
- JDBC
- RMI
- Reflection which supported Introspection only, no modification at runtime was possible.
- JIT (Just In Time) compiler for Windows
- Internationalization and Unicode support originating from Taligent

<sub>[Back to top](#table-of-contents)</sub>

## Java 1.2
(released in December 1998)

- strictfp keyword
- Swing graphical API
- Sun’s JVM was equipped with a JIT compiler for the first time
- Java plug-in
- Collections framework
- Reference Types

<sub>[Back to top](#table-of-contents)</sub>

## Java 1.3
(released in May 2000)

- HotSpot JVM
- Java Naming and Directory Interface (JNDI)
- Java Platform Debugger Architecture (JPDA)
- JavaSound
- Synthetic proxy classes

<sub>[Back to top](#table-of-contents)</sub>

## Java 1.4
(released in February 2002)

- assert keyword
- Regular expressions
- Exception chaining
- Internet Protocol version 6 (IPv6) support
- New I/O; NIO
- Logging API
- Image I/O API
- Integrated XML parser and XSLT processor (JAXP)
- Integrated security and cryptography extensions (JCE, JSSE, JAAS)
- Java Web Start
- Preferences API (java.util.prefs)

<sub>[Back to top](#table-of-contents)</sub>

## Java 5
(released in September 2004)

- Generics
- Annotations
- Autoboxing/unboxing
- Enumerations
- Varargs
- Enhanced for each loop
- Static imports
- New concurrency utilities in java.util.concurrent
- Scanner class for parsing data from various input streams and buffers.

<sub>[Back to top](#table-of-contents)</sub>

## Java 6
(released in December 2006)

- Scripting Language Support
- Performance improvements
- JAX-WS
- JDBC 4.0
- Java Compiler API
- JAXB 2.0 and StAX parser
- Pluggable annotations
- New GC algorithms

<sub>[Back to top](#table-of-contents)</sub>

## Java 7
(released in July 2011)

 - JVM support for dynamic languages
 - Compressed 64-bit pointers
 - Strings in switch
 - Automatic resource management in try-statement
 - The diamond operator
 - Simplified varargs method declaration
 - Binary integer literals
 - Underscores in numeric literals
 - Improved exception handling
 - ForkJoin Framework
 - NIO 2.0 having support for multiple file systems, file metadata and symbolic links
 - WatchService
 - Timsort is used to sort collections and arrays of objects instead of merge sort
 - APIs for the graphics features
 - Support for new network protocols, including SCTP and Sockets Direct Protocol

<sub>[Back to top](#table-of-contents)</sub>

## Java 8
(released in March 2014):

 - [Lambda expression support in APIs](java-8/features/lamda-expression.md)
 - [Method References](java-8/features/method-references.md)
 - Stream API
 - Functional interface and default methods
 - Optionals
 - Nashorn — JavaScript runtime which allows developers to embed JavaScript code within applications
 - Annotation on Java Types
 - Unsigned Integer Arithmetic
 - [Repeating annotations](java-8/features/repeating-annotations.md)
 - New Date and Time API
 - Statically-linked JNI libraries
 - Launch JavaFX applications from jar files
 - Remove the permanent generation from GC

<sub>[Back to top](#table-of-contents)</sub>

## Java 9
(released in September 2017):

- Modular system (Project Jigsaw)
- JShell (interactive Java shell)
- HTTP/2 client
- Reactive Streams API
- Process API updates
- Private methods in interfaces
- Improved version string scheme 

<sub>[Back to top](#table-of-contents)</sub>

## Java 10
(released in March 2018):

- Local variable type inference (var keyword)
- Application class-data sharing
- Garbage Collector Interface
- Time-based release versioning

<sub>[Back to top](#table-of-contents)</sub>

## Java 11
(released in September 2018):

- Local variable syntax for lambda parameters
- HTTP Client API (standardized)
- Flight Recorder (profiling and diagnostics)
- Launch Single-File Source-Code Programs
- Epsilon Garbage Collector

<sub>[Back to top](#table-of-contents)</sub>

## Java 12
(released in March 2019):

- Switch expressions (preview feature)
- Compact Number Formatting
- Teeing Collectors
- Shenandoah Garbage Collector (experimental)
- Microbenchmark Suite

<sub>[Back to top](#table-of-contents)</sub>

## Java 13
(released in September 2019):

- Text blocks (preview feature)
- Switch expressions (standard feature)
- Dynamic CDS Archives
- ZGC (experimental garbage collector)
- Reimplement the Legacy Socket API

<sub>[Back to top](#table-of-contents)</sub>

## Java 14
(released in March 2020):

- Pattern matching for instanceof (preview feature)
- Records (preview feature)
- Helpful NullPointerExceptions
- ZGC: Concurrent Thread-Stack Processing
- Non-Volatile Mapped Byte Buffers

<sub>[Back to top](#table-of-contents)</sub>

## Java 15
(released in September 2020):

- Sealed classes (preview feature)
- Hidden classes
- Text blocks (standard feature)
- ZGC: NUMA-Aware Memory Allocation
- Unix-Domain Socket Channels

<sub>[Back to top](#table-of-contents)</sub>

## Java 16
(released in March 2021):

- Records (standard feature)
- Sealed classes (standard feature)
- Pattern matching for instanceof (standard feature)
- Foreign function and memory API (Incubator)
- Alpine Linux Support

<sub>[Back to top](#table-of-contents)</sub>

## Java 17
(released in September 2021):

- Sealed classes (final form)
- Pattern matching for switch (preview feature)
- Strong encapsulation of JDK internals
- Foreign function and memory API (standard feature)
- Sealed class JARs
- macOS rendering pipeline for AWT and Swing

<sub>[Back to top](#table-of-contents)</sub>

## Java 18
(released in March 2022):

-  UTF-8 by Default
-  Simple Web Server
-  Code Snippets in Java API Documentation
-  Reimplement Core Reflection with Method Handles
-  Vector API (Third Incubator)
-  Internet-Address Resolution SPI
-  Foreign Function & Memory API (Second Incubator)
-  Pattern Matching for switch (Second Preview)
-  Deprecate Finalization for Removal

<sub>[Back to top](#table-of-contents)</sub>

## Java 19
(released in September 2022):

-  Record Patterns (Preview)
-  Linux/RISC-V Port
-  Foreign Function & Memory API (Preview)
-  Virtual Threads (Preview)
-  Vector API (Fourth Incubator)
-  Pattern Matching for switch (Third Preview)
-  Structured Concurrency (Incubator)

<sub>[Back to top](#table-of-contents)</sub>

## Java 20
(released in March 2023):

-  Scoped Values (Incubator)
-  Record Patterns (Second Preview)
-  Pattern Matching for switch (Fourth Preview)
-  Foreign Function & Memory API (Second Preview)
-  Virtual Threads (Second Preview)
-  Structured Concurrency (Second Incubator)
-  Vector API (Fifth Incubator)

<sub>[Back to top](#table-of-contents)</sub>

## Java 21
(to be released in September 2023):

-  String Templates (Preview)
-  Sequenced Collections
-  Generational ZGC
-  Record Patterns
-  Pattern Matching for switch
-  Foreign Function & Memory API (Third Preview)
-  Unnamed Patterns and Variables (Preview)
-  Virtual Threads
-  Unnamed Classes and Instance Main Methods (Preview)
-  Scoped Values (Preview)
-  Vector API (Sixth Incubator)
-  Deprecate the Windows 32-bit x86 Port for Removal
-  Prepare to Disallow the Dynamic Loading of Agents
-  Key Encapsulation Mechanism API
-  Structured Concurrency (Preview)

<sub>[Back to top](#table-of-contents)</sub>


___

[Index](../../common/table-of-contents.md) |
[Java](java.md#how-is-java-versioned) |
[Back to top](#table-of-contents)
___
### Ref.

 - https://medium.com/codex/java-history-from-1-0-to-java-18-d62f69b2a48a
 - https://www.marcobehler.com/guides/a-guide-to-java-versions-and
 - https://ondro.inginea.eu/index.php/new-in-java-versions-since-java-8/
 - https://en.wikipedia.org/wiki/Java_version_history
