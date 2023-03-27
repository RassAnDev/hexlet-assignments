package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat() {

    }

    public Flat(double flatArea, double flatBalconyArea, int flatFloor) {
        this.area = flatArea;
        this.balconyArea = flatBalconyArea;
        this.floor = flatFloor;
    }

    public double getFlatArea() {
        return area;
    }

    public void setArea(double flatArea) {
        this.area = flatArea;
    }

    public double getBalconyArea() {
        return balconyArea;
    }

    public void setBalconyArea(double flatBalconyArea) {
        this.balconyArea = flatBalconyArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int flatFloor) {
        this.floor = flatFloor;
    }

    public double getArea() {
        return getFlatArea() + getBalconyArea();
    }

    public int compareTo(Home another) {
        return Double.compare(this.getArea(), another.getArea());
    }

    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + getFloor() + " этаже";
    }
}
// END
