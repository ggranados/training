# Method references

<!-- TOC -->
* [Method references](#method-references)
  * [Examples](#examples)
  * [Ref.](#ref)
<!-- TOC -->

___

Shorthand syntax for referring to an existing method by its name. They provide a concise way to pass a method as an argument or to assign a method to a functional interface. 

Method references can be seen as a more compact alternative to lambda expressions when the lambda expression simply calls an existing method without any additional logic.

The syntax for method references in Java is as follows:

```java
ClassName::methodName
```

There are several types of method references in Java:

Reference to a static method:

```java
ClassName::staticMethodName
```
        
Reference to an instance method of a particular object:

```java
instance::instanceMethodName
```

Reference to an instance method of an arbitrary object of a particular type:

```java
ClassName::instanceMethodName
```        
        
Reference to a constructor:

```java
ClassName::new
```

___

## Examples

Capitalizing and printing a list of Strings:
   ````java
   List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
   ````

We can achieve this by leveraging a simple lambda expression calling the ``StringUtils.capitalize()`` method directly:
   ````java
   messages.forEach(word -> StringUtils.capitalize(word));
   ````

Or, we can use a method reference to simply refer to the capitalize static method:
   ````java 
   messages.forEach(StringUtils::capitalize);
   ````

___

## Ref.

___

[Get Started](../../../../../get-started.md) |
[Java 8](../versions.md#java-8-lts)

___