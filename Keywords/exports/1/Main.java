// Program 1
public class Main {
    enum Days {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        Days today = Days.MONDAY;
        System.out.println("Today is: " + today);
    }
}
