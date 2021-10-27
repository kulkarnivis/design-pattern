# design-pattern
Well-proved solution for solving the specific problem/task

Design patterns are programming language independent strategies for solving the common object-oriented design problems. That means, a design pattern represents an idea, not a particular implementation.
By using the design patterns makes code more flexible, reusable and maintainable.

# advantages of design pattern
* They are reusable in multiple projects.
* They provide the solutions that help to define the system architecture.
* They capture the software engineering experiences.
* They provide transparency to the design of an application.
* Design patterns don't guarantee an absolute solution to a problem. They provide clarity to the system architecture and the possibility of building a better system.

# When should we use the design patterns?
* use the design patterns during the analysis and requirement phase of SDLC(Software Development Life Cycle).

# Classification of patterns
Design patterns differ by their complexity, level of detail and scale of applicability to the entire system being designed.In addition, all patterns can be categorized by their intent, or purpose.

Purpose       | Design Pattern    | Aspect(s) that can vary
------------- | -------------     | ---------------------------------
Creational    |                   | provide object creation mechanisms that increase flexibility and reuse of existing code.
Creational    | Factory Method    | provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
Creational    | Abstract Factory  | lets you produce families of related objects without specifying their concrete classes.
Creational    | Singleton         | lets you ensure that a class has only one instance, while providing a global access point to this instance. 
Creational    | Builder           | lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.
Creational    | Prototype         | lets you copy existing objects without making your code dependent on their classes.     
Structural    |                   | These patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient
Adapter       |   | allows objects with incompatible interfaces to collaborate.
Bridge       |   | lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.
Composite   |   | lets you compose objects into tree structures and then work with these structures as if they were individual objects.
Decorator   |   | lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.
Facade   |   | provides a simplified interface to a library, a framework, or any other complex set of classes.
Flyweight |   | lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
Proxy   |   | lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.

Behavioral    |                   | take care of effective communication and the assignment of responsibilities between objects.
