package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage() {

    }

    public Cottage(double cottageArea, int cottageFloorCount) {
        this.area = cottageArea;
        this.floorCount = cottageFloorCount;
    }

    public double getArea() {
        return this.area;
    }

    public int compareTo(Home another) {
        return Double.compare(this.getArea(), another.getArea());
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }
}
// END
