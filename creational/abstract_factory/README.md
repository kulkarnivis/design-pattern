# Abstract Factory
It is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.

## When to use
* The client is independent of how we create and compose the objects in the system
* The system consists of multiple families of objects, and these families are designed to be used together
* We need a run-time value to construct a particular dependency

## Pros and cons

Pros | Cons
-----| ----
 You can be sure that the products you’re getting from a factory are compatible with each other. | The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern.
You avoid tight coupling between concrete products and client code.|
 Single Responsibility Principle. You can extract the product creation code into one place, making the code easier to support.|
 Open/Closed Principle. You can introduce new variants of products without breaking existing client code.|

## Abstract Factory method pattern in JDK
DocumentBuilderFactory: https://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/DocumentBuilderFactory.html#newInstance--
xpathfactory: https://docs.oracle.com/javase/9/docs/api/javax/xml/xpath/XPathFactory.html#newInstance-java.lang.String-

## Usecase : 
We are going to create a Shape interface and a concrete class implementing it. We create an abstract factory class AbstractFactory as next step. Factory class ShapeFactory is defined, which extends AbstractFactory. A factory creator/generator class FactoryProducer is created.

AbstractFactoryPatternDemo, our demo class uses FactoryProducer to get a AbstractFactory object. It will pass information (CIRCLE / RECTANGLE / SQUARE for Shape) to AbstractFactory to get the type of object it needs.

![image](https://user-images.githubusercontent.com/51394570/139076944-b9bcf318-5ef3-4e08-8ba7-9b45e7ee6de3.png)



## Implementation using kotlin

[Code implementation](https://github.com/kulkarnivis/design-pattern/tree/main/creational/factory_method/src/main/kotlin)

**Create Notification interface**

```
interface Notification {
    fun notifyUser()
}
```
Note- Above interface could be created as an abstract class as well. 
```
abstract class Notification {
    abstract fun notifyUser()
}
```

Create all implementation classes

```
SMSNotification.kt
```

```
class SMSNotification: Notification {
    override fun notifyUser() {
        println("Sending an SMS notification")
    }
}
```

```
EmailNotification.kt
```

```
public class EmailNotification: Notification {
    override fun notifyUser()
    {
        println("Sending an e-mail notification");
    }
}
```

```
PushNotification.kt
```

```
public class PushNotification: Notification {
    override fun notifyUser()
    {
        println("Sending a push notification");
    }
}
```
Create a factory class NotificationFactory.kt to instantiate concrete class.

```
class NotificationFactory {
    fun createNotification(channel: String?): Notification? {
            if (channel == null || channel.isEmpty())
                return null

            return when (channel) {
                "SMS" -> {
                    SMSNotification()
                }
                "EMAIL" -> {
                    EmailNotification()
                }
                "PUSH" -> {
                    PushNotification()
                }
                else -> null
            }
        }
}
```

Now let’s use factory class to create and get an object of concrete class by passing some information. 

```
fun main(){
    NotificationFactory().createNotification("SMS")?.notifyUser()
}
```

```
Output : Sending an SMS notification
```
