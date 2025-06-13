public class Main {
    public static void main(String[] args) {
        // Create a Point record
        Point point = new Point(10, 20);
        System.out.println(point); // Output: Point[x=10, y=20]

        // Create a Rectangle record
        Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(10, 10));
        System.out.println(rectangle); // Output: Rectangle[topLeft=Point[x=0, y=0], bottomRight=Point[x=10, y=10]]
    }
}


