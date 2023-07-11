### Lambda Expression

Before Java 8, whenever you wanted to instantiate, for example, a new Runnable, you had to write an anonymous inner class like so:

````java
Runnable runnable = new Runnable(){
    @Override
    public void run(){
        System.out.println("Hello world !");
    }
};
````

With lambdas, the same code looks like this:
````java
Runnable runnable = () -> System.out.println("Hello world two!");
````

## Exercises

[Lambda sintaxis](https://github.com/ggranados/java/blob/1fcad199e4f05cbd866a31f49e116a4bb33cfba9/FunctionalProgramming/src/org/linkedinlearning/functionalprogramming/lambda/Lambda1.java)
___

[Index](../../../../common/table-of-contents.md) |
[Java 8](../../versions.md#java-8)

___