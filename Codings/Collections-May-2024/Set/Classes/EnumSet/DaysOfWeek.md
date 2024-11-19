## Problem: 
Implementing a Days of the Week Enumerator

## Description: 
Create a program that demonstrates the use of EnumSet to represent a set of days of the week.

## Input:

Monday

Wednesday

Friday

## Output:
[MONDAY, WEDNESDAY, FRIDAY]

## Code Answer:
```Java
import java.util.*;

public class DaysOfWeek {
public enum Day {
MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

    public static void main(String[] args) {
        EnumSet<Day> days = EnumSet.of(Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY);
        System.out.println(days);
    }
}
```

File Name: DaysOfWeek.java

This program demonstrates the use of EnumSet to represent a set of days of the week. The DaysOfWeek class defines an enum Day representing the days of the week. The main method creates an EnumSet containing three days (Monday, Wednesday, and Friday) and prints the set.
Note: EnumSet is a specialized Set implementation for enums. It is more efficient and provides additional methods for working with enums.