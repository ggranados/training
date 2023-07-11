### Method references

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

[Back](../../versions.md) |
[Index](../../../../common/table-of-contents.md)

___