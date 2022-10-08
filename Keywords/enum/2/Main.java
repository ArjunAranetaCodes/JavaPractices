// Program 2
public class Main {
    enum Color {
        RED, GREEN, BLUE;

        public void display() {
            System.out.println("Color: " + this);
        }
    }

    public static void main(String[] args) {
        Color myColor = Color.BLUE;
    }
}
