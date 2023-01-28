public class Main {
    enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;

        switch (today) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("It's a weekday");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("It's a weekend");
                break;
        }
    }
}
