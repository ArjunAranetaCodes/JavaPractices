import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class DateTimeSample {
    public static void main(String[] args) {
        // Get current date and time
        java.util.Date utilDate = new java.util.Date();

        // Convert utilDate to sqlDate, sqlTime, and sqlTimestamp
        Date sqlDate = new Date(utilDate.getTime());
        Time sqlTime = new Time(utilDate.getTime());
        Timestamp sqlTimestamp = new Timestamp(utilDate.getTime());

        // Print the results
        System.out.println("java.util.Date: " + utilDate);
        System.out.println("java.sql.Date: " + sqlDate);
        System.out.println("java.sql.Time: " + sqlTime);
        System.out.println("java.sql.Timestamp: " + sqlTimestamp);
    }
}