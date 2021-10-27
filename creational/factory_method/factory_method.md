# Factory Method

It is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

## Usecase : 
Consider we want to implement a notification service through email, SMS, and push notification. Let’s try to implement this with the help of factory method design pattern. First we will design a UML class diagram for this. 

In Java constructors are not polymorphic, but by allowing subclass to create an object, we are adding polymorphic behavior to the instantiation. In short, we are trying to achieve Pseudo polymorphism by letting the subclass to decide what to create, and so this Factory method is also called as Virtual constructor.

![image](https://user-images.githubusercontent.com/51394570/139050855-5772cdab-b620-4264-9fd7-e90641fff4dc.png)

## Implementation

**Create Notification interface**

```public interface Notification {
    void notifyUser();
}```
