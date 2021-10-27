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
