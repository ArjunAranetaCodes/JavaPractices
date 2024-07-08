```Java
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Main {
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
```
This program creates a java.util.Date object to represent the current date and time. It then converts this object to java.sql.Date, java.sql.Time, and java.sql.Timestamp objects.

The output of this program will look something like this:
```
java.util.Date: Thu Jun 06 12:00:00 AEST 2024

java.sql.Date: 2024-06-06

java.sql.Time: 12:00:00

java.sql.Timestamp: 2024-06-06 12:00:00.0
```

As you can see, java.sql.Date only contains the date, java.sql.Time only contains the time, and java.sql.Timestamp contains both the date and time.

Note that java.sql.Date, java.sql.Time, and java.sql.Timestamp are all subclasses of java.util.Date, so they can be used wherever a java.util.Date is expected. However, they are generally used in specific contexts:
```
java.sql.Date is typically used in database queries to represent a date without a time component.

java.sql.Time is typically used in database queries to represent a time without a date component.

java.sql.Timestamp is typically used in database queries to represent a date and time.
```