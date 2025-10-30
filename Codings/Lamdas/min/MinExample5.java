import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MinExample5 {
    public static void main(String[] args) {
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2023, 5, 15),
                LocalDate.of(2023, 3, 10),
                LocalDate.of(2023, 8, 22)
        );

        LocalDate minDate = dates.stream().min(LocalDate::compareTo).orElse(null);

        System.out.println("Minimum date: " + minDate);
    }
}
