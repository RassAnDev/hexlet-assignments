package exercise;

// BEGIN
public class Circle {
    private Point point;
    private int radius;
    public Circle(Point circlePoint, int circleRadius) {
        this.point = circlePoint;
        this.radius = circleRadius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return Math.PI * Math.pow(radius, 2);
    }
}
// END
