## Problem: 
Implementing a Day of the Week Enumerator

## Description: 
Create a program that demonstrates the use of EnumMap to implement a day of the week enumerator.

## Input:

Days of the week: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday

## Output:

Day of the week enumerator:

Monday = 1

Tuesday = 2

Wednesday = 3

Thursday = 4

Friday = 5

Saturday = 6

Sunday = 7

## Code Answer:
```Java
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
```

File Name: DayOfWeekEnumerator.java

This program demonstrates the use of EnumMap to implement a day of the week enumerator. The DayOfWeekEnumerator class uses an EnumMap to store the day of the week and its corresponding number, and provides a method to retrieve the day number. The main() method tests the enumerator by printing the day of the week and its corresponding number.

Note: EnumMap is a specialized Map implementation for enumerations, and is useful for creating enumerators, dictionaries, and other similar data structures that need to be accessed by enumeration values.