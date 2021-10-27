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
