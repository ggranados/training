# Diamond Operator

---

## Table of Contents
<!-- TOC -->
* [Diamond Operator](#diamond-operator)
  * [Table of Contents](#table-of-contents)
  * [Overview](#overview)
  * [Ref.](#ref)
<!-- TOC -->

---

## Overview

Before the diamond operator, when creating instances of generic classes, you had to explicitly specify the type parameter twice, once during declaration and once during instantiation:

```java
List<String> myList = new ArrayList<String>(); // Java 6 and earlier
```

With the diamond operator, the redundant type information can be omitted:

```java
List<String> myList = new ArrayList<>(); // Java 7 and later
```

The diamond operator works with any generic class, not just ArrayList

```java
Map<String, Integer> myMap = new HashMap<>(); // Java 7 and later
Set<Double> mySet = new HashSet<>(); // Java 7 and later
```

The Java 1.7 compiler's type inference feature determines the most suitable constructor declaration that matches the invocation.

- See also: [Collections API](../java-1_2/collections-api.md)
- See also: [Generics](../java-5/generics.md)

<sub>[Back to top](#table-of-contents)</sub>


---

## Ref.

https://www.baeldung.com/java-diamond-operator

---

[Get Started](../../../../../get-started.md) |
[Languages](../../../../../get-started.md#languages) |
[Java Development](../develop.md#generics-and-collections) |
[Java 7](../versions.md#java-7)

---