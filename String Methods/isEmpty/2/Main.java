public class Main {
    public static void main(String[] args) {
        String day = "Monday";
        
        switch (day.intern()) {
            case "Monday":
                System.out.println("It's Monday!");
                break;
            case "Tuesday":
                System.out.println("It's Tuesday!");
                break;
            default:
                System.out.println("It's another day.");
        }
    }
}
 