# Java DateTime Tutorial - July 2025

## Overview

This tutorial covers Java's modern DateTime API introduced in Java 8, which provides a comprehensive and user-friendly way to work with dates, times, and time zones. The old `java.util.Date` and `java.util.Calendar` classes had many issues, which led to the creation of this new API.

## Table of Contents

1. [Introduction to Java DateTime API](#introduction)
2. [Core Classes](#core-classes)
3. [Current Date and Time](#current-date-and-time)
4. [Creating Specific Dates and Times](#creating-specific-dates-and-times)
5. [Formatting and Parsing](#formatting-and-parsing)
6. [Date and Time Calculations](#date-and-time-calculations)
7. [Period and Duration](#period-and-duration)
8. [Time Zones](#time-zones)
9. [Comparisons](#comparisons)
10. [Instants](#instants)
11. [Practical Examples](#practical-examples)
12. [Best Practices](#best-practices)
13. [Common Pitfalls](#common-pitfalls)

## Introduction

The Java DateTime API is designed to be:
- **Immutable**: All classes are immutable, making them thread-safe
- **Clear and readable**: Method names are self-explanatory
- **Comprehensive**: Covers all date/time use cases
- **Extensible**: Easy to extend for custom requirements

## Core Classes

### Main Classes

| Class | Purpose | Example |
|-------|---------|---------|
| `LocalDate` | Date without time | `2025-07-15` |
| `LocalTime` | Time without date | `14:30:45` |
| `LocalDateTime` | Date and time | `2025-07-15T14:30:45` |
| `ZonedDateTime` | Date and time with timezone | `2025-07-15T14:30:45-05:00[America/New_York]` |
| `Instant` | Point in time (timestamp) | `2025-07-15T19:30:45Z` |

### Supporting Classes

| Class | Purpose |
|-------|---------|
| `Period` | Amount of time in years, months, days |
| `Duration` | Amount of time in hours, minutes, seconds |
| `ZoneId` | Time zone identifier |
| `ZoneOffset` | Time zone offset from UTC |
| `DateTimeFormatter` | Format and parse dates/times |

## Current Date and Time

### Getting Current Values

```java
// Current date
LocalDate today = LocalDate.now();
System.out.println("Today: " + today); // 2025-07-15

// Current time
LocalTime now = LocalTime.now();
System.out.println("Now: " + now); // 14:30:45.123

// Current date and time
LocalDateTime currentDateTime = LocalDateTime.now();
System.out.println("Current: " + currentDateTime); // 2025-07-15T14:30:45.123

// Current with timezone
ZonedDateTime zonedNow = ZonedDateTime.now();
System.out.println("Zoned: " + zonedNow); // 2025-07-15T14:30:45.123-05:00[America/New_York]

// Current instant (timestamp)
Instant instant = Instant.now();
System.out.println("Instant: " + instant); // 2025-07-15T19:30:45.123Z
```

## Creating Specific Dates and Times

### Creating Dates

```java
// Using of() method
LocalDate date1 = LocalDate.of(2025, 7, 15);
LocalDate date2 = LocalDate.of(2025, Month.JULY, 15);

// From year and day of year
LocalDate date3 = LocalDate.ofYearDay(2025, 196); // July 15, 2025

// From epoch day
LocalDate date4 = LocalDate.ofEpochDay(18500); // July 15, 2025
```

### Creating Times

```java
// Using of() method
LocalTime time1 = LocalTime.of(14, 30, 45);
LocalTime time2 = LocalTime.of(14, 30, 45, 123000000); // with nanoseconds

// From seconds of day
LocalTime time3 = LocalTime.ofSecondOfDay(52245); // 14:30:45

// From nano of day
LocalTime time4 = LocalTime.ofNanoOfDay(52245000000000L); // 14:30:45
```

### Creating DateTimes

```java
// Using of() method
LocalDateTime dateTime1 = LocalDateTime.of(2025, 7, 15, 14, 30, 45);
LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);

// From date and time
LocalDateTime dateTime3 = date1.atTime(time1);
LocalDateTime dateTime4 = date1.atTime(14, 30, 45);
```

## Formatting and Parsing

### Formatting

```java
LocalDateTime dateTime = LocalDateTime.of(2025, 7, 15, 14, 30, 45);

// Custom patterns
DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
String formatted1 = dateTime.format(formatter1); // "2025-07-15 14:30:45"

DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
String formatted2 = dateTime.format(formatter2); // "15/07/2025 14:30"

// Predefined formatters
String isoDate = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE); // "2025-07-15"
String isoTime = dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME); // "14:30:45"

// Localized formatting
DateTimeFormatter localized = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy", Locale.US);
String localizedStr = dateTime.format(localized); // "Tuesday, July 15, 2025"
```

### Parsing

```java
// Parsing ISO format
LocalDate date = LocalDate.parse("2025-07-15");
LocalTime time = LocalTime.parse("14:30:45");
LocalDateTime dateTime = LocalDateTime.parse("2025-07-15T14:30:45");

// Parsing custom format
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
LocalDateTime parsed = LocalDateTime.parse("15/07/2025 14:30", formatter);
```

## Date and Time Calculations

### Adding and Subtracting

```java
LocalDate today = LocalDate.now();

// Adding
LocalDate tomorrow = today.plusDays(1);
LocalDate nextWeek = today.plusWeeks(1);
LocalDate nextMonth = today.plusMonths(1);
LocalDate nextYear = today.plusYears(1);

// Subtracting
LocalDate yesterday = today.minusDays(1);
LocalDate lastWeek = today.minusWeeks(1);
LocalDate lastMonth = today.minusMonths(1);
LocalDate lastYear = today.minusYears(1);

// Time calculations
LocalTime now = LocalTime.now();
LocalTime inOneHour = now.plusHours(1);
LocalTime inThirtyMinutes = now.plusMinutes(30);
LocalTime inOneSecond = now.plusSeconds(1);
```

### Temporal Adjusters

```java
LocalDate today = LocalDate.now();

// Common adjustments
LocalDate firstDayOfMonth = today.withDayOfMonth(1);
LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
LocalDate previousFriday = today.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));

// Custom adjustments
LocalDate nextWorkingDay = today.with(temporal -> {
    LocalDate date = (LocalDate) temporal;
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    if (dayOfWeek == DayOfWeek.FRIDAY) {
        return date.plusDays(3); // Monday
    } else if (dayOfWeek == DayOfWeek.SATURDAY) {
        return date.plusDays(2); // Monday
    } else {
        return date.plusDays(1);
    }
});
```

## Period and Duration

### Period (Date-based)

```java
LocalDate birthDate = LocalDate.of(1990, 5, 15);
LocalDate today = LocalDate.now();

// Calculate period between dates
Period age = Period.between(birthDate, today);
System.out.println("Age: " + age.getYears() + " years, " + 
                   age.getMonths() + " months, " + 
                   age.getDays() + " days");

// Creating periods
Period oneYear = Period.ofYears(1);
Period sixMonths = Period.ofMonths(6);
Period twoWeeks = Period.ofWeeks(2);
Period threeDays = Period.ofDays(3);

// Adding periods to dates
LocalDate futureDate = today.plus(oneYear).plus(sixMonths);
```

### Duration (Time-based)

```java
LocalTime startTime = LocalTime.of(9, 0);
LocalTime endTime = LocalTime.of(17, 30);

// Calculate duration between times
Duration workDay = Duration.between(startTime, endTime);
System.out.println("Work day: " + workDay.toHours() + " hours, " + 
                   workDay.toMinutesPart() + " minutes");

// Creating durations
Duration oneHour = Duration.ofHours(1);
Duration thirtyMinutes = Duration.ofMinutes(30);
Duration oneSecond = Duration.ofSeconds(1);
Duration oneMillisecond = Duration.ofMillis(1);

// Adding durations to times
LocalTime futureTime = startTime.plus(oneHour).plus(thirtyMinutes);
```

## Time Zones

### Working with Time Zones

```java
// Getting time in different zones
ZoneId newYorkZone = ZoneId.of("America/New_York");
ZoneId londonZone = ZoneId.of("Europe/London");
ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");

ZonedDateTime newYorkTime = ZonedDateTime.now(newYorkZone);
ZonedDateTime londonTime = ZonedDateTime.now(londonZone);
ZonedDateTime tokyoTime = ZonedDateTime.now(tokyoZone);

// Converting between zones
LocalDateTime localDateTime = LocalDateTime.of(2025, 7, 15, 14, 30);
ZonedDateTime convertedToNY = localDateTime.atZone(ZoneId.systemDefault())
                                          .withZoneSameInstant(newYorkZone);

// Working with offsets
ZoneOffset offset = ZoneOffset.ofHours(-5);
OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, offset);
```

### Available Time Zones

```java
// Get all available time zones
Set<String> availableZones = ZoneId.getAvailableZoneIds();
availableZones.stream()
    .filter(zone -> zone.startsWith("America"))
    .forEach(System.out::println);

// Get system default time zone
ZoneId systemZone = ZoneId.systemDefault();
System.out.println("System zone: " + systemZone);
```

## Comparisons

### Comparing Dates and Times

```java
LocalDate date1 = LocalDate.of(2025, 7, 15);
LocalDate date2 = LocalDate.of(2025, 8, 15);
LocalDate date3 = LocalDate.of(2025, 7, 15);

// Equality
boolean equals = date1.equals(date3); // true

// Before/After
boolean before = date1.isBefore(date2); // true
boolean after = date2.isAfter(date1); // true

// Compare
int comparison = date1.compareTo(date2); // negative value

// Time comparisons
LocalTime time1 = LocalTime.of(9, 0);
LocalTime time2 = LocalTime.of(17, 30);
boolean isBefore = time1.isBefore(time2); // true
```

### Range Checking

```java
LocalDate startDate = LocalDate.of(2025, 7, 1);
LocalDate endDate = LocalDate.of(2025, 7, 31);
LocalDate checkDate = LocalDate.of(2025, 7, 15);

// Check if date is in range
boolean isInRange = !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);

// Alternative using isAfter and isBefore
boolean isInRange2 = checkDate.isAfter(startDate.minusDays(1)) && 
                     checkDate.isBefore(endDate.plusDays(1));
```

## Instants

### Working with Instants

```java
// Current instant
Instant now = Instant.now();

// Creating instant from epoch
Instant epoch = Instant.ofEpochSecond(0);
Instant specificEpoch = Instant.ofEpochSecond(1626350400); // July 15, 2021

// Converting between LocalDateTime and Instant
LocalDateTime localDateTime = LocalDateTime.of(2025, 7, 15, 14, 30);
Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

// Converting back
LocalDateTime convertedBack = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

// Adding duration
Instant futureInstant = now.plus(Duration.ofHours(24));

// Getting epoch values
long epochSeconds = now.getEpochSecond();
long epochMillis = now.toEpochMilli();
```

## Practical Examples

### Example 1: Age Calculator

```java
public static int calculateAge(LocalDate birthDate) {
    return Period.between(birthDate, LocalDate.now()).getYears();
}

LocalDate birthDate = LocalDate.of(1990, 5, 15);
int age = calculateAge(birthDate);
System.out.println("Age: " + age + " years");
```

### Example 2: Business Days Calculator

```java
public static long calculateBusinessDays(LocalDate startDate, LocalDate endDate) {
    long businessDays = 0;
    LocalDate current = startDate;
    
    while (!current.isAfter(endDate)) {
        DayOfWeek dayOfWeek = current.getDayOfWeek();
        if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
            businessDays++;
        }
        current = current.plusDays(1);
    }
    
    return businessDays;
}
```

### Example 3: Relative Time Formatter

```java
public static String formatRelativeTime(LocalDateTime pastTime) {
    LocalDateTime now = LocalDateTime.now();
    Duration duration = Duration.between(pastTime, now);
    
    if (duration.toDays() > 0) {
        return duration.toDays() + " days ago";
    } else if (duration.toHours() > 0) {
        return duration.toHours() + " hours ago";
    } else if (duration.toMinutes() > 0) {
        return duration.toMinutes() + " minutes ago";
    } else {
        return "Just now";
    }
}
```

### Example 4: Business Hours Checker

```java
public static boolean isBusinessHours(LocalTime time) {
    LocalTime businessStart = LocalTime.of(9, 0);
    LocalTime businessEnd = LocalTime.of(17, 0);
    return !time.isBefore(businessStart) && !time.isAfter(businessEnd);
}
```

## Best Practices

### 1. Use Appropriate Classes

- Use `LocalDate` for date-only operations
- Use `LocalTime` for time-only operations
- Use `LocalDateTime` for date and time without timezone
- Use `ZonedDateTime` when timezone matters
- Use `Instant` for timestamps

### 2. Immutability

```java
// Good: Create new instances
LocalDate today = LocalDate.now();
LocalDate tomorrow = today.plusDays(1);

// Bad: Don't try to modify existing instances
// today.setDayOfMonth(16); // This doesn't exist!
```

### 3. Thread Safety

```java
// All DateTime classes are thread-safe
LocalDate date = LocalDate.of(2025, 7, 15);
// Can be safely shared across threads
```

### 4. Performance

```java
// Reuse formatters (they are thread-safe)
private static final DateTimeFormatter FORMATTER = 
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

// Use in methods
String formatted = dateTime.format(FORMATTER);
```

### 5. Null Safety

```java
// Always check for null before operations
public static String formatDate(LocalDate date) {
    if (date == null) {
        return "N/A";
    }
    return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
}
```

## Common Pitfalls

### 1. Mixing Old and New APIs

```java
// Avoid mixing old and new APIs
// Bad:
Date oldDate = new Date();
LocalDateTime newDateTime = LocalDateTime.now();
// Don't mix these!

// Good: Use only the new API
LocalDateTime dateTime = LocalDateTime.now();
```

### 2. Timezone Confusion

```java
// Be careful with timezone conversions
LocalDateTime local = LocalDateTime.of(2025, 7, 15, 14, 30);
// This doesn't have timezone information!

// Use ZonedDateTime when timezone matters
ZonedDateTime zoned = ZonedDateTime.of(local, ZoneId.of("America/New_York"));
```

### 3. Format Pattern Mistakes

```java
// Common pattern mistakes
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
// Use 'HH' for 24-hour format, 'hh' for 12-hour format
// Use 'MM' for month, 'mm' for minute
```

### 4. Period vs Duration Confusion

```java
// Period is for date-based calculations
Period period = Period.ofDays(1);
LocalDate tomorrow = LocalDate.now().plus(period);

// Duration is for time-based calculations
Duration duration = Duration.ofHours(1);
LocalTime later = LocalTime.now().plus(duration);

// Don't mix them!
// LocalDate.now().plus(duration); // Compilation error!
```

## Running the Examples

To run the `DateTimeExamples.java` program:

1. Compile the program:
   ```bash
   javac DateTimeExamples.java
   ```

2. Run the program:
   ```bash
   java DateTimeExamples
   ```

The program will demonstrate all the concepts covered in this tutorial with practical examples.

## Additional Resources

- [Java 8 DateTime API Documentation](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html)
- [Java DateTime Tutorial](https://docs.oracle.com/javase/tutorial/datetime/)
- [DateTimeFormatter Patterns](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)

## Conclusion

The Java DateTime API provides a robust, thread-safe, and easy-to-use way to work with dates and times. By following the best practices outlined in this tutorial, you can write clean, maintainable code that handles all your date and time requirements effectively.

Remember:
- Always use the new API instead of the old `Date` and `Calendar` classes
- Choose the appropriate class for your use case
- Be mindful of timezone considerations
- Reuse formatters for better performance
- Handle null values appropriately 