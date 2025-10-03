public class Main {
    public enum Color {
        RED, GREEN, BLUE
    }

    public static void main(String[] args) {
        Color color = Color.BLUE;

        switch (color) {
            case RED:
                System.out.println("Red color");
                break;
            case GREEN:
                System.out.println("Green color");
                break;
            case BLUE:
                System.out.println("Blue color");
                break;
            default:
                System.out.println("Unknown color"); 
        }
    }
}
