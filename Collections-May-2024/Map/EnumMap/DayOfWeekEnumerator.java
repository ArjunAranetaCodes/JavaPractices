import java.util.EnumMap;
import java.util.Map;

public class DayOfWeekEnumerator {
    private EnumMap<DayOfWeek, Integer> dayMap;

    public DayOfWeekEnumerator() {
        dayMap = new EnumMap<>(DayOfWeek.class);
        dayMap.put(DayOfWeek.MONDAY, 1);
        dayMap.put(DayOfWeek.TUESDAY, 2);
        dayMap.put(DayOfWeek.WEDNESDAY, 3);
        dayMap.put(DayOfWeek.THURSDAY, 4);
        dayMap.put(DayOfWeek.FRIDAY, 5);
        dayMap.put(DayOfWeek.SATURDAY, 6);
        dayMap.put(DayOfWeek.SUNDAY, 7);
    }

    public int getDayNumber(DayOfWeek day) {
        return dayMap.get(day);
    }

    public static void main(String[] args) {
        DayOfWeekEnumerator enumerator = new DayOfWeekEnumerator();

        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day + " = " + enumerator.getDayNumber(day));
        }
    }
}

enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}