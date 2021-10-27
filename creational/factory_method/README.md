# Factory Method

It is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

## Usecase : 
Consider we want to implement a notification service through email, SMS, and push notification. Let’s try to implement this with the help of factory method design pattern. First we will design a UML class diagram for this. 

In Java constructors are not polymorphic, but by allowing subclass to create an object, we are adding polymorphic behavior to the instantiation. In short, we are trying to achieve Pseudo polymorphism by letting the subclass to decide what to create, and so this Factory method is also called as Virtual constructor.

![image](https://user-images.githubusercontent.com/51394570/139050855-5772cdab-b620-4264-9fd7-e90641fff4dc.png)

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
