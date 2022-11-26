public class Main {
    public static void main(String[] args) {
        int choice = 2;

        switch (choice) {
            case 1:
                System.out.println("Option 1 selected");
                break;
            case 2:
                System.out.println("Option 2 selected, breaking the switch");
                break;
            case 3:
                break;
            default:
        }
    }
}
