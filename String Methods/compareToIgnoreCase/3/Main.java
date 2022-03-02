import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date(System.currentTimeMillis() - 100000);
        
        int result = date1.compareTo(date2);
        
        System.out.println("Comparison result: " + result);
    }
}
