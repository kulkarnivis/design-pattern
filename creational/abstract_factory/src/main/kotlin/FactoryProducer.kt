class FactoryProducer {
    fun getFactory(rounded: Boolean): AbstractFactory {
        return if (rounded) {
            RoundedShapeFactory()
        } else {
            ShapeFactory()
        }
    }
}
