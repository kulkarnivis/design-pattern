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
interface Shape {
    fun draw()
}
```
Note- Above interface could be created as an abstract class as well. 

Create all implementation classes

```
RoundedRectangle.kt
```

```
class RoundedRectangle: Shape {
    override fun draw() {
        println("Inside RoundedRectangle::draw() method.")
    }
}
```
```
RoundedSquare.kt
```

```
class RoundedSquare:Shape {
    override fun draw() {
        println("Inside RoundedSquare::draw() method.")
    }
}
```
```
Rectangle.kt
```
```
class Rectangle: Shape {
    override fun draw() {
        println("Inside Rectangle::draw() method.")
    }
}
```
```
AbstractFactory.kt
```

```
abstract class AbstractFactory {
    abstract fun getShape(shapeType: String?): Shape?
}
```
```
ShapeFactory.kt
```
```
class ShapeFactory: AbstractFactory() {
    override fun getShape(shapeType: String?): Shape? {
        when {
            shapeType.equals("RECTANGLE") -> {
                return Rectangle()
            }
            shapeType.equals("SQUARE") -> {
                return Square()
            }
            else -> return null
        }
    }
}
```
```
RoundedShapeFactory.kt
```
```
class RoundedShapeFactory: AbstractFactory() {
    override fun getShape(shapeType: String?): Shape? {
        if (shapeType.equals("RECTANGLE")) {
            return RoundedRectangle()
        } else if (shapeType.equals("SQUARE")) {
            return RoundedSquare()
        }
        return null
    }
}
```
```
FactoryProducer.kt
```

```
class FactoryProducer {
    fun getFactory(rounded: Boolean): AbstractFactory {
        return if (rounded) {
            RoundedShapeFactory()
        } else {
            ShapeFactory()
        }
    }
}

```
```
Main.kt
```

```
fun main() {
    //get shape factory
    val shapeFactory: AbstractFactory = FactoryProducer().getFactory(false)
    //get an object of Shape Rectangle
    val shape1 = shapeFactory.getShape("RECTANGLE")
    //call draw method of Shape Rectangle
    shape1!!.draw()
    //get an object of Shape Square
    val shape2 = shapeFactory.getShape("SQUARE")
    //call draw method of Shape Square
    shape2!!.draw()
    //get shape factory
    val shapeFactory1: AbstractFactory = FactoryProducer().getFactory(true)
    //get an object of Shape Rectangle
    val shape3 = shapeFactory1.getShape("RECTANGLE")
    //call draw method of Shape Rectangle
    shape3!!.draw()
    //get an object of Shape Square
    val shape4 = shapeFactory1.getShape("SQUARE")
    //call draw method of Shape Square
    shape4!!.draw()
}
```
```
Output:

Inside Rectangle::draw() method.
Inside Square::draw() method.
Inside RoundedRectangle::draw() method.
Inside RoundedSquare::draw() method.
```
