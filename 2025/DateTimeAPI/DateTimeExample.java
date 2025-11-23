/**
 * Tutorial: Date and Time API
 * Demonstrates Java 8+ Date/Time API
 */
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeExample {
    public static void main(String[] args) {
        // LocalDate - date without time
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);
        
        LocalDate specificDate = LocalDate.of(2025, 12, 25);
        System.out.println("Specific Date: " + specificDate);
        
        // LocalTime - time without date
        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);
        
        LocalTime specificTime = LocalTime.of(14, 30, 45);
        System.out.println("Specific Time: " + specificTime);
        
        // LocalDateTime - date and time
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + dateTime);
        
        // DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = dateTime.format(formatter);
        System.out.println("Formatted: " + formatted);
        
        // Duration - time between two instants
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 30);
        Duration duration = Duration.between(start, end);
        System.out.println("Duration: " + duration.toHours() + " hours");
        
        // Period - date-based amount of time
        LocalDate startDate = LocalDate.of(2025, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 12, 31);
        Period period = Period.between(startDate, endDate);
        System.out.println("Period: " + period.getMonths() + " months, " + period.getDays() + " days");
        
        // ChronoUnit
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Days between: " + daysBetween);
    }
}

