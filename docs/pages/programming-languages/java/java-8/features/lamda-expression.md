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

___

[Back](../../versions.md) |
[Index](../../../../common/table-of-contents.md)

___