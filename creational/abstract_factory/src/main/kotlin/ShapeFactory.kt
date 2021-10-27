class ShapeFactory: AbstractFactory() {
    override fun getShape(shapeType: String?): Shape? {
        return when {
            shapeType.equals("RECTANGLE") -> {
                Rectangle()
            }
            shapeType.equals("SQUARE") -> {
                Square()
            }
            else -> null
        }
    }
}
