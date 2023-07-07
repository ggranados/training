# Spring

- BeanPostProcesor
- BeanPostProcessorFactory
- How SpringBoot works

- IoC example not DI
	Dependency injection is a software design pattern and a technique commonly used in object-oriented programming to implement the principle of inversion of control (IoC). It involves providing the dependencies of an object externally, rather than having the object create or manage its dependencies internally.

	We can achieve Inversion of Control through various mechanisms such as: Strategy design pattern, Service Locator pattern, Factory pattern, and Dependency Injection (DI).

	Besides Dependency Injection (DI) and the Service Locator pattern, there are a few other implementations of the Inversion of Control (IoC) principle. These include:

	1. Template Method Pattern: In the Template Method pattern, the control flow is inverted by defining a template or skeleton of an algorithm in a base class, while allowing subclasses to override certain steps or methods of the algorithm. The base class controls the overall flow and invokes the overridden methods in the subclasses at appropriate times, effectively inverting the control of specific implementation details to the subclasses.

	2. Event-driven Architecture: Event-driven architecture (EDA) is a design approach where the flow of control is driven by events and event handlers. Instead of a centralized control flow, the system responds to events and delegates the processing to the appropriate event handlers. The events act as triggers, and components or services subscribe to specific events of interest and respond accordingly. This decouples the components and enables a flexible, asynchronous, and loosely coupled system.

	3. Inversion of Control Containers: Inversion of Control (IoC) containers or frameworks provide a comprehensive implementation of the IoC principle. These containers manage the creation, configuration, and lifecycle of objects, including their dependencies. IoC containers often use techniques like reflection, configuration files, annotations, or code-based configuration to automatically resolve and inject dependencies. They provide a centralized and automated approach to control the flow of dependencies and object instantiation within an application.

	4. Aspect-Oriented Programming (AOP): AOP complements IoC by addressing cross-cutting concerns, such as logging, security, and transaction management, which often span multiple components or modules in an application. In AOP, these concerns are modularized and separated from the core business logic. Aspects, representing these concerns, are defined separately and then woven into the application at runtime. AOP frameworks or libraries take care of weaving the aspects into the appropriate points in the program execution.

These are a few additional implementations of the IoC principle. Each approach has its strengths and focuses on different aspects of the application design and control flow. The choice of implementation depends on the specific requirements and architectural considerations of the application being developed.


# Java

- HashTree vs HashMap
- Concurrency Java
- Thread wait vs thread block

# Architecture

- Architechture patterns
- SOLID
- Design patterns
- Adapter vs Bridge vs Proxy vs Decorator

# Web

- REST ESB
- RESFUL
- HATEOAS


- ACID
- having
- Isolation Levels
