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

### Examples

- Lambda expression

Overall, the code aims to illustrate how lambda expressions can simplify the implementation of functional interfaces and make the code more readable and concise.

The code defines a Comparator interface for comparing Employee objects based on their names. It starts with a traditional anonymous class implementation and then converts it into lambda expressions in several steps.

The code also demonstrates the usage of lambda expressions with the Runnable interface. It creates multiple Thread instances using lambda expressions to define the behavior of the thread.

Lastly, the code showcases a lambda expression with a single parameter using the Consumer functional interface. It defines a Consumer that takes a String and prints its length.

<div style="max-height: 300px; overflow: auto;">

```java
package org.linkedinlearning.functionalprogramming.lambda;

import org.linkedinlearning.functionalprogramming.pojo.Employee;

import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda1 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        // old fashion anonymous class implementation
        Comparator<Employee> byName = new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.getName().compareTo(b.getName());
            }
        };

        // First lambda expression
        Comparator<Employee> byNameLambda1 =
                (Employee a, Employee b) -> {return a.getName().compareTo(b.getName()); };

        // Removing parameter types
        Comparator<Employee> byNameLambda2 =
                (a,b) -> { return a.getName().compareTo(b.getName()); };

        // Removing braces and return
        Comparator<Employee> byNameLambda3 =
                (a,b) -> a.getName().compareTo(b.getName());


        // Expression with no parameter
        Runnable r = () -> {
            System.out.println("A compact Runnable!");
        };

        Thread t1 = new Thread(r);

        // No need to even mention Runnable
        Thread t2 = new Thread(() -> {
            System.out.println("An implicit Runnable");
        });

        // No need for braces here
        Thread t3 = new Thread(() -> System.out.println("An implicit Runnable!"));

        // Expression with one parameter
        Consumer<String> lengthPrinter =
                s -> System.out.println(s.length());
    }
}
```

</div>

<sub>[View on Github](https://github.com/ggranados/java/blob/1fcad199e4f05cbd866a31f49e116a4bb33cfba9/FunctionalProgramming/src/org/linkedinlearning/functionalprogramming/lambda/Lambda1.java)</sub>


___

[Index](../../../../../common/table-of-contents.md) |
[Java 8](../../versions.md#java-8-lts)

___