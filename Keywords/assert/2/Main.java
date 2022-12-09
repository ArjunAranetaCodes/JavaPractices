public class Main {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        assert x == y : "Values are not equal: x=" + x + ", y=" + y;
        System.out.println("Values are equal");
    }
}
