# Factory Method

It is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

## Usecase : 
Consider we want to implement a notification service through email, SMS, and push notification. Let’s try to implement this with the help of factory method design pattern. First we will design a UML class diagram for this. 

In Java constructors are not polymorphic, but by allowing subclass to create an object, we are adding polymorphic behavior to the instantiation. In short, we are trying to achieve Pseudo polymorphism by letting the subclass to decide what to create, and so this Factory method is also called as Virtual constructor.

![image](https://user-images.githubusercontent.com/51394570/139050855-5772cdab-b620-4264-9fd7-e90641fff4dc.png)

## Implementation

**Create Notification interface**

```
public interface Notification {
    void notifyUser();
}
```
Note- Above interface could be created as an abstract class as well. 
```
public abstract class Notification {
    public abstract void notifyUser();
}
```

Create all implementation classes

```
SMSNotification.java
```

```
public class SMSNotification implements Notification {
 
    @Override
    public void notifyUser()
    {
        System.out.println("Sending an SMS notification");
    }
}
```

```
EmailNotification.java
```

```
public class EmailNotification implements Notification {
    @Override
    public void notifyUser()
    {
        System.out.println("Sending an e-mail notification");
    }
}
```

```
PushNotification.java
```

```
public class PushNotification implements Notification {
 
    @Override
    public void notifyUser()
    {
        System.out.println("Sending a push notification");
    }
}
```
Create a factory class NotificationFactory.java to instantiate concrete class.

```
public class NotificationFactory {
    public Notification createNotification(String channel)
    {
        if (channel == null || channel.isEmpty())
            return null;
        if ("SMS".equals(channel)) {
            return new SMSNotification();
        }
        else if ("EMAIL".equals(channel)) {
            return new EmailNotification();
        }
        else if ("PUSH".equals(channel)) {
            return new PushNotification();
        }
        return null;
    }
}
```

Now let’s use factory class to create and get an object of concrete class by passing some information. 

```
public class NotificationService {
    public static void main(String[] args)
    {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        notification.notifyUser();
    }
}
```

```
Output : Sending an SMS notification
```
