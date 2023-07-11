## Lambda Expression

Before Java 8, whenever you wanted to instantiate, for example, a new Runnable, you had to write an anonymous inner class like so:

```java
Runnable runnable = new Runnable(){
    @Override
    public void run(){
        System.out.println("Hello world !");
    }
};
```

With lambdas, the same code looks like this:
```java
Runnable runnable = () -> System.out.println("Hello world two!");
```

---

### Exercises

- [Lambda sintaxis on GitHub](https://github.com/ggranados/java/blob/1fcad199e4f05cbd866a31f49e116a4bb33cfba9/FunctionalProgramming/src/org/linkedinlearning/functionalprogramming/lambda/Lambda1.java)

Overall, the code aims to illustrate how lambda expressions can simplify the implementation of functional interfaces and make the code more readable and concise.

The code defines a Comparator interface for comparing Employee objects based on their names. It starts with a traditional anonymous class implementation and then converts it into lambda expressions in several steps.

The code also demonstrates the usage of lambda expressions with the Runnable interface. It creates multiple Thread instances using lambda expressions to define the behavior of the thread.

Lastly, the code showcases a lambda expression with a single parameter using the Consumer functional interface. It defines a Consumer that takes a String and prints its length.

```java
https://raw.githubusercontent.com/ggranados/java/1fcad199e4f05cbd866a31f49e116a4bb33cfba9/FunctionalProgramming/src/org/linkedinlearning/functionalprogramming/lambda/Lambda1.java
```



___

[Index](../../../../common/table-of-contents.md) |
[Java 8](../../versions.md#java-8)

___