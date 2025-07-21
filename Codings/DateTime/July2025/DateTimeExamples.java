import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.*;

/**
 * Comprehensive Java DateTime Examples
 * Demonstrates various DateTime operations using Java 8+ DateTime API
 * 
 * @author Java Practice
 * @version 1.0
 * @since July 2025
 */
public class DateTimeExamples {
    
    public static void main(String[] args) {
        System.out.println("=== Java DateTime Examples ===\n");
        
        // 1. Current Date and Time
        demonstrateCurrentDateTime();
        
        // 2. Creating Specific Dates and Times
        demonstrateCreatingDateTime();
        
        // 3. Date and Time Formatting
        demonstrateFormatting();
        
        // 4. Date and Time Parsing
        demonstrateParsing();
        
        // 5. Date and Time Calculations
        demonstrateCalculations();
        
        // 6. Period and Duration
        demonstratePeriodAndDuration();
        
        // 7. Time Zones
        demonstrateTimeZones();
        
        // 8. Date and Time Comparisons
        demonstrateComparisons();
        
        // 9. Working with Instants
        demonstrateInstants();
        
        // 10. Practical Examples
        demonstratePracticalExamples();
    }
    
    /**
     * Demonstrates getting current date and time
     */
    private static void demonstrateCurrentDateTime() {
        System.out.println("1. CURRENT DATE AND TIME");
        System.out.println("=========================");
        
        // Current date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);
        
        // Current time
        LocalTime now = LocalTime.now();
        System.out.println("Current time: " + now);
        
        // Current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current date and time: " + currentDateTime);
        
        // Current date and time with timezone
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Current zoned date time: " + zonedDateTime);
        
        // Current instant (timestamp)
        Instant instant = Instant.now();
        System.out.println("Current instant: " + instant);
        
        System.out.println();
    }
    
    /**
     * Demonstrates creating specific dates and times
     */
    private static void demonstrateCreatingDateTime() {
        System.out.println("2. CREATING SPECIFIC DATES AND TIMES");
        System.out.println("====================================");
        
        // Creating specific date
        LocalDate specificDate = LocalDate.of(2025, 7, 15);
        System.out.println("Specific date: " + specificDate);
        
        // Creating specific time
        LocalTime specificTime = LocalTime.of(14, 30, 45);
        System.out.println("Specific time: " + specificTime);
        
        // Creating specific date and time
        LocalDateTime specificDateTime = LocalDateTime.of(2025, 7, 15, 14, 30, 45);
        System.out.println("Specific date and time: " + specificDateTime);
        
        // Creating date from year and day of year
        LocalDate fromDayOfYear = LocalDate.ofYearDay(2025, 196); // July 15, 2025
        System.out.println("Date from day of year: " + fromDayOfYear);
        
        // Creating time from seconds of day
        LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(52245); // 14:30:45
        System.out.println("Time from seconds of day: " + fromSecondsOfDay);
        
        System.out.println();
    }
    
    /**
     * Demonstrates date and time formatting
     */
    private static void demonstrateFormatting() {
        System.out.println("3. DATE AND TIME FORMATTING");
        System.out.println("============================");
        
        LocalDateTime dateTime = LocalDateTime.of(2025, 7, 15, 14, 30, 45);
        
        // Using DateTimeFormatter
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted1 = dateTime.format(formatter1);
        System.out.println("Formatted (yyyy-MM-dd HH:mm:ss): " + formatted1);
        
        // Different format patterns
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String formatted2 = dateTime.format(formatter2);
        System.out.println("Formatted (dd/MM/yyyy HH:mm): " + formatted2);
        
        // Using predefined formatters
        String isoDate = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String isoTime = dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("ISO date: " + isoDate);
        System.out.println("ISO time: " + isoTime);
        
        // Formatting with locale
        DateTimeFormatter localizedFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy", Locale.US);
        String localized = dateTime.format(localizedFormatter);
        System.out.println("Localized format: " + localized);
        
        // Formatting time zones
        ZonedDateTime zoned = ZonedDateTime.now();
        DateTimeFormatter zoneFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String zonedFormatted = zoned.format(zoneFormatter);
        System.out.println("Zoned format: " + zonedFormatted);
        
        System.out.println();
    }
    
    /**
     * Demonstrates date and time parsing
     */
    private static void demonstrateParsing() {
        System.out.println("4. DATE AND TIME PARSING");
        System.out.println("=========================");
        
        // Parsing date
        String dateStr = "2025-07-15";
        LocalDate parsedDate = LocalDate.parse(dateStr);
        System.out.println("Parsed date: " + parsedDate);
        
        // Parsing time
        String timeStr = "14:30:45";
        LocalTime parsedTime = LocalTime.parse(timeStr);
        System.out.println("Parsed time: " + parsedTime);
        
        // Parsing date and time
        String dateTimeStr = "2025-07-15T14:30:45";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeStr);
        System.out.println("Parsed date time: " + parsedDateTime);
        
        // Parsing with custom format
        String customStr = "15/07/2025 14:30";
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime customParsed = LocalDateTime.parse(customStr, customFormatter);
        System.out.println("Custom parsed: " + customParsed);
        
        // Parsing with locale
        String localizedStr = "Tuesday, July 15, 2025";
        DateTimeFormatter localizedFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy", Locale.US);
        LocalDate localizedParsed = LocalDate.parse(localizedStr, localizedFormatter);
        System.out.println("Localized parsed: " + localizedParsed);
        
        System.out.println();
    }
    
    /**
     * Demonstrates date and time calculations
     */
    private static void demonstrateCalculations() {
        System.out.println("5. DATE AND TIME CALCULATIONS");
        System.out.println("==============================");
        
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        
        // Adding days, months, years
        LocalDate tomorrow = today.plusDays(1);
        LocalDate nextMonth = today.plusMonths(1);
        LocalDate nextYear = today.plusYears(1);
        System.out.println("Tomorrow: " + tomorrow);
        System.out.println("Next month: " + nextMonth);
        System.out.println("Next year: " + nextYear);
        
        // Subtracting time periods
        LocalDate yesterday = today.minusDays(1);
        LocalDate lastMonth = today.minusMonths(1);
        System.out.println("Yesterday: " + yesterday);
        System.out.println("Last month: " + lastMonth);
        
        // Adding hours, minutes, seconds
        LocalTime inOneHour = now.plusHours(1);
        LocalTime inThirtyMinutes = now.plusMinutes(30);
        LocalTime inOneSecond = now.plusSeconds(1);
        System.out.println("In one hour: " + inOneHour);
        System.out.println("In thirty minutes: " + inThirtyMinutes);
        System.out.println("In one second: " + inOneSecond);
        
        // Working with specific fields
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("First day of month: " + firstDayOfMonth);
        System.out.println("Last day of month: " + lastDayOfMonth);
        System.out.println("Next Monday: " + nextMonday);
        
        // Getting specific parts
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        System.out.println("Year: " + year + ", Month: " + month + ", Day: " + day + ", Day of Week: " + dayOfWeek);
        
        System.out.println();
    }
    
    /**
     * Demonstrates Period and Duration
     */
    private static void demonstratePeriodAndDuration() {
        System.out.println("6. PERIOD AND DURATION");
        System.out.println("=======================");
        
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        LocalDate today = LocalDate.now();
        
        // Calculating period between dates
        Period age = Period.between(birthDate, today);
        System.out.println("Age: " + age.getYears() + " years, " + age.getMonths() + " months, " + age.getDays() + " days");
        
        // Creating periods
        Period oneYear = Period.ofYears(1);
        Period sixMonths = Period.ofMonths(6);
        Period twoWeeks = Period.ofWeeks(2);
        System.out.println("One year period: " + oneYear);
        System.out.println("Six months period: " + sixMonths);
        System.out.println("Two weeks period: " + twoWeeks);
        
        // Duration for time-based calculations
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 30);
        Duration workDay = Duration.between(startTime, endTime);
        System.out.println("Work day duration: " + workDay.toHours() + " hours, " + workDay.toMinutesPart() + " minutes");
        
        // Creating durations
        Duration oneHour = Duration.ofHours(1);
        Duration thirtyMinutes = Duration.ofMinutes(30);
        Duration oneSecond = Duration.ofSeconds(1);
        System.out.println("One hour: " + oneHour);
        System.out.println("Thirty minutes: " + thirtyMinutes);
        System.out.println("One second: " + oneSecond);
        
        // Adding periods and durations
        LocalDate futureDate = today.plus(oneYear).plus(sixMonths);
        LocalTime futureTime = startTime.plus(oneHour).plus(thirtyMinutes);
        System.out.println("Future date: " + futureDate);
        System.out.println("Future time: " + futureTime);
        
        System.out.println();
    }
    
    /**
     * Demonstrates time zone operations
     */
    private static void demonstrateTimeZones() {
        System.out.println("7. TIME ZONES");
        System.out.println("=============");
        
        // Getting current time in different zones
        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZoneId londonZone = ZoneId.of("Europe/London");
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        
        ZonedDateTime newYorkTime = ZonedDateTime.now(newYorkZone);
        ZonedDateTime londonTime = ZonedDateTime.now(londonZone);
        ZonedDateTime tokyoTime = ZonedDateTime.now(tokyoZone);
        
        System.out.println("New York time: " + newYorkTime);
        System.out.println("London time: " + londonTime);
        System.out.println("Tokyo time: " + tokyoTime);
        
        // Converting between time zones
        LocalDateTime localDateTime = LocalDateTime.of(2025, 7, 15, 14, 30);
        ZonedDateTime convertedToNY = localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(newYorkZone);
        System.out.println("Local time converted to NY: " + convertedToNY);
        
        // Getting available time zones
        Set<String> availableZones = ZoneId.getAvailableZoneIds();
        System.out.println("Number of available time zones: " + availableZones.size());
        
        // Working with offset
        ZoneOffset offset = ZoneOffset.ofHours(-5);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, offset);
        System.out.println("Offset date time: " + offsetDateTime);
        
        System.out.println();
    }
    
    /**
     * Demonstrates date and time comparisons
     */
    private static void demonstrateComparisons() {
        System.out.println("8. DATE AND TIME COMPARISONS");
        System.out.println("=============================");
        
        LocalDate date1 = LocalDate.of(2025, 7, 15);
        LocalDate date2 = LocalDate.of(2025, 8, 15);
        LocalDate date3 = LocalDate.of(2025, 7, 15);
        
        // Comparing dates
        System.out.println("Date1: " + date1);
        System.out.println("Date2: " + date2);
        System.out.println("Date3: " + date3);
        
        System.out.println("Date1 equals Date3: " + date1.equals(date3));
        System.out.println("Date1 before Date2: " + date1.isBefore(date2));
        System.out.println("Date2 after Date1: " + date2.isAfter(date1));
        System.out.println("Date1 compareTo Date2: " + date1.compareTo(date2));
        
        // Comparing times
        LocalTime time1 = LocalTime.of(9, 0);
        LocalTime time2 = LocalTime.of(17, 30);
        
        System.out.println("Time1: " + time1);
        System.out.println("Time2: " + time2);
        System.out.println("Time1 before Time2: " + time1.isBefore(time2));
        System.out.println("Time2 after Time1: " + time2.isAfter(time1));
        
        // Checking if date is in range
        LocalDate checkDate = LocalDate.of(2025, 7, 20);
        boolean isInRange = !checkDate.isBefore(date1) && !checkDate.isAfter(date2);
        System.out.println("Is " + checkDate + " in range [" + date1 + ", " + date2 + "]: " + isInRange);
        
        System.out.println();
    }
    
    /**
     * Demonstrates working with Instants
     */
    private static void demonstrateInstants() {
        System.out.println("9. WORKING WITH INSTANTS");
        System.out.println("=========================");
        
        // Current instant
        Instant now = Instant.now();
        System.out.println("Current instant: " + now);
        
        // Creating instant from epoch seconds
        Instant epoch = Instant.ofEpochSecond(0);
        System.out.println("Epoch instant: " + epoch);
        
        // Converting between LocalDateTime and Instant
        LocalDateTime localDateTime = LocalDateTime.of(2025, 7, 15, 14, 30);
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println("LocalDateTime to Instant: " + instant);
        
        // Converting Instant back to LocalDateTime
        LocalDateTime convertedBack = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("Instant to LocalDateTime: " + convertedBack);
        
        // Adding duration to instant
        Instant futureInstant = now.plus(Duration.ofHours(24));
        System.out.println("24 hours from now: " + futureInstant);
        
        // Getting epoch seconds and milliseconds
        long epochSeconds = now.getEpochSecond();
        long epochMillis = now.toEpochMilli();
        System.out.println("Epoch seconds: " + epochSeconds);
        System.out.println("Epoch milliseconds: " + epochMillis);
        
        System.out.println();
    }
    
    /**
     * Demonstrates practical examples
     */
    private static void demonstratePracticalExamples() {
        System.out.println("10. PRACTICAL EXAMPLES");
        System.out.println("=======================");
        
        // Example 1: Calculate age
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        System.out.println("Age: " + age + " years");
        
        // Example 2: Check if it's weekend
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        boolean isWeekend = today == DayOfWeek.SATURDAY || today == DayOfWeek.SUNDAY;
        System.out.println("Is weekend: " + isWeekend);
        
        // Example 3: Calculate business days (excluding weekends)
        LocalDate startDate = LocalDate.of(2025, 7, 15);
        LocalDate endDate = LocalDate.of(2025, 7, 25);
        long businessDays = calculateBusinessDays(startDate, endDate);
        System.out.println("Business days between " + startDate + " and " + endDate + ": " + businessDays);
        
        // Example 4: Format relative time
        LocalDateTime pastTime = LocalDateTime.now().minusHours(2).minusMinutes(30);
        String relativeTime = formatRelativeTime(pastTime);
        System.out.println("Relative time: " + relativeTime);
        
        // Example 5: Check if time is within business hours
        LocalTime currentTime = LocalTime.now();
        boolean isBusinessHours = isWithinBusinessHours(currentTime);
        System.out.println("Is business hours: " + isBusinessHours);
        
        // Example 6: Calculate next business day
        LocalDate nextBusinessDay = getNextBusinessDay(LocalDate.now());
        System.out.println("Next business day: " + nextBusinessDay);
        
        System.out.println();
    }
    
    /**
     * Calculates business days between two dates (excluding weekends)
     */
    private static long calculateBusinessDays(LocalDate startDate, LocalDate endDate) {
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
    
    /**
     * Formats relative time (e.g., "2 hours ago", "yesterday")
     */
    private static String formatRelativeTime(LocalDateTime pastTime) {
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
    
    /**
     * Checks if time is within business hours (9 AM - 5 PM)
     */
    private static boolean isWithinBusinessHours(LocalTime time) {
        LocalTime businessStart = LocalTime.of(9, 0);
        LocalTime businessEnd = LocalTime.of(17, 0);
        return !time.isBefore(businessStart) && !time.isAfter(businessEnd);
    }
    
    /**
     * Gets the next business day (skips weekends)
     */
    private static LocalDate getNextBusinessDay(LocalDate date) {
        LocalDate nextDay = date.plusDays(1);
        while (nextDay.getDayOfWeek() == DayOfWeek.SATURDAY || nextDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
            nextDay = nextDay.plusDays(1);
        }
        return nextDay;
    }
} 