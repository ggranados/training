### Diamond Operator
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

---


<!-- TODO: -->