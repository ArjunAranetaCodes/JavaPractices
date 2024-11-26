import java.util.*;

public class AddIntegers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(); // create an ArrayList object
        
        for (int i = 0; i < 10; i++) {
            numbers.add(i); // add integers from 0 to 9
        }
        
        System.out.println("Numbers added: " + numbers);
    }
}