# SOLID

## Table of Contents
<!-- TOC -->
* [SOLID](#solid)
  * [Table of Contents](#table-of-contents)
  * [Single Responsibility Principle (SRP)](#single-responsibility-principle-srp)
  * [Open/Closed Principle (OCP)](#openclosed-principle-ocp)
  * [Liskov Substitution Principle (LSP)](#liskov-substitution-principle-lsp)
  * [Interface Segregation Principle (ISP)](#interface-segregation-principle-isp)
  * [Dependency Inversion Principle (DIP):](#dependency-inversion-principle-dip)
  * [Ref.](#ref)
<!-- TOC -->


SOLID is an acronym that represents a set of five design principles in object-oriented programming (**OOP**) and software design. These principles were introduced by Robert C. Martin and are intended to _guide developers in creating more maintainable and scalable software_ by promoting clean, flexible, and understandable code. 

The SOLID principles include:

## Single Responsibility Principle (SRP)

    This principle states that _a class should have only one reason to change_. In other words, _a class should have a single responsibility or job_. 
    
    >This helps keep classes focused and makes them easier to understand and maintain.

  ```java
  // Incorrect: This class violates SRP.
  class Employee {
    private String name;
    private int id;
  
    public void save() {
      // Code to save employee details to the database.
    }
  
    public void generateReport() {
      // Code to generate an employee report.
    }
  }
  ```
  
  In the above example, the Employee class is responsible for both saving employee data to a database and generating reports. It's better to separate these responsibilities into different classes.
  
  ```java
  // Correct: Separate classes for different responsibilities.
  class Employee {
    private String name;
    private int id;
  }
  
  class EmployeeSaver {
    public void save(Employee employee) {
  // Code to save employee details to the database.
    }
  }
  
  class EmployeeReportGenerator {
    public void generateReport(Employee employee) {
  // Code to generate an employee report.
    }
  }
  ```

<sub>[Back to top](#table-of-contents)</sub>
    
## Open/Closed Principle (OCP)

    States that software entities (classes, modules, functions, etc.) _should be open for extension but closed for modification_. This means that you should be able to add new functionality to a system without altering existing code. 
    
    > This is often achieved through the use of inheritance and interfaces.

  ```java
  // Incorrect: Modifying existing class to add a new shape.
  class Circle {
      public void draw() {
          // Code to draw a circle.
      }
  }
  
  // Now, we want to add a new shape, but this requires modifying the existing code.
  class Square {
      public void draw() {
          // Code to draw a square.
      }
  }
  ```
  
  Instead, we can use abstraction to make the code open for extension:
  
  ```java
  // Correct: Using interfaces and inheritance to allow extension.
  interface Shape {
      void draw();
  }
  
  class Circle implements Shape {
      public void draw() {
          // Code to draw a circle.
      }
  }
  
  class Square implements Shape {
      public void draw() {
          // Code to draw a square.
      }
  }
  ```

<sub>[Back to top](#table-of-contents)</sub>
    
## Liskov Substitution Principle (LSP)
    The Liskov Substitution Principle states that _objects of a derived class should be able to replace objects of the base class without affecting the correctness of the program_. 
    >In other words, derived classes should be substitutable for their base classes without causing unexpected behavior.

  ```java
  // LSP Example

  abstract class Bird {
    abstract void move();
  }
  
  class Sparrow extends Bird {
    void move() {
    System.out.println("Sparrow is flying.");
    }
  }
  
  class Ostrich extends Bird {
    void move() {
    System.out.println("Ostrich is running.");
    }
  }
  
  public class Main {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird ostrich = new Ostrich();

        sparrow.move(); // Outputs: "Sparrow is flying."
        ostrich.move(); // Outputs: "Ostrich is running."
      }
  }
  ```

In this example, the `Bird` class has an abstract move method. Both the `Sparrow` and `Ostrich` classes correctly implement the `move` method according to their respective abilities. This adheres to the Liskov Substitution Principle, as you can use instances of `Sparrow` and `Ostrich` interchangeably with the `Bird` reference, and their behavior is consistent with the expected behavior of different bird types. Additionally, there are no issues related to the Interface Segregation Principle in this example.

<sub>[Back to top](#table-of-contents)</sub>
    
## Interface Segregation Principle (ISP)
    The Interface Segregation Principle suggests that _clients should not be forced to depend on interfaces they do not use_. It promotes the idea of creating specific, small, and focused interfaces rather than having large, monolithic ones. 
   >This helps avoid forcing classes to implement methods they don't need.

  ```java
  // Incorrect: A single, large interface.
  interface Worker {
      void work();
      void eat();
  }
  
  class Engineer implements Worker {
      public void work() {
          // Code for engineering work.
      }
  
      public void eat() {
          // Code for eating lunch.
      }
  }
  // In this case, the Engineer class is forced to implement the eat() method, which it doesn't need.
  ```
  
  
  A correct example follows ISP:
  
  ```java
  
  // Correct: Separate interfaces for different behaviors.
  interface Workable {
      void work();
  }
  
  interface Eatable {
      void eat();
  }
  
  class Engineer implements Workable {
      public void work() {
          // Code for engineering work.
      }
  }
  
  class LunchBreak implements Eatable {
      public void eat() {
          // Code for eating lunch.
      }
  }
  ```

<sub>[Back to top](#table-of-contents)</sub>
   
## Dependency Inversion Principle (DIP):
  The Dependency Inversion Principle advocates that *high-level modules should not depend on low-level modules*. Both should depend on abstractions. This principle encourages the use of interfaces or abstract classes to define the relationships between components in a way that makes it easier to replace one component with another without affecting the overall system.

  ```java
  // Incorrect: High-level class depends on a low-level class directly.
  class LightBulb {
    public void turnOn() {
      // Code to turn on the light bulb.
    }
  
    public void turnOff() {
      // Code to turn off the light bulb.
    }
  }
  
  class Switch {
    private LightBulb bulb;
  
    public Switch() {
              bulb = new LightBulb(); // High-level class depends on a concrete low-level class.
    }
  
    public void operate() {
      if (bulb.isOn()) {
                bulb.turnOff();
      } else {
                bulb.turnOn();
      }
    }
  }
  ```
  
  A correct example follows DIP:
  
  ```java
  
  // Correct: High-level class depends on an abstraction (interface).
  interface Switchable {
    void turnOn();
  
    void turnOff();
  
    boolean isOn();
  }
  
  class LightBulb implements Switchable {
    public void turnOn() {
      // Code to turn on the light bulb.
    }
  
    public void turnOff() {
      // Code to turn off the light bulb.
    }
  
    public boolean isOn() {
      // Code to check if the light bulb is on.
    }
  }
  
  class Switch {
    private Switchable device;
  
    public Switch(Switchable device) {
              this.device = device; // High-level class depends on an abstraction.
    }
  
    public void operate() {
      if (device.isOn()) {
                device.turnOff();
      } else {
                device.turnOn();
      }
    }
  }
  ```

  These examples demonstrate how to apply each SOLID principle in Java to create more maintainable and flexible code.


By following the SOLID principles, developers aim to create software that is more modular, easier to maintain, and less prone to bugs when changes are made. These principles are considered best practices in the world of software engineering and are widely used in designing object-oriented systems.

<sub>[Back to top](#table-of-contents)</sub>

___

## Ref.

- https://www.baeldung.com/java-single-responsibility-principle
- https://stackify.com/solid-design-open-closed-principle/
- https://en.wikipedia.org/wiki/Interface_segregation_principle
- https://stackify.com/dependency-inversion-principle/

___

[Get Started](../../get-started.md) |
[Paradigms](../../get-started.md#design-patterns) |
[OOP](../programming/paradigms/object-oriented.md)

---