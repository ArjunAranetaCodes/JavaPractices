import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String formattedDate = dateFormat.format(currentDate);
        System.out.println("Current Date: " + formattedDate);
    }
}
