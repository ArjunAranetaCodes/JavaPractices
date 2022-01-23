public class Main {
    public static void main(String[] args) {
        String day = "MONday";

        switch (day.toLowerCase()) {
            case "monday":
                System.out.println("It's the first day of the week.");
                break;
            case "friday":
                System.out.println("It's almost the weekend!");
                break;
            default:
                System.out.println("It's a regular day.");
        }
    }
}
 