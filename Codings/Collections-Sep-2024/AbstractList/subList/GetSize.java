import java.util.*;

public class GetSize {
    public static void main(String[] args) {
        List<Double> temperatures = new ArrayList<>(); // create an empty ArrayList
        
        temperatures.add(37.5);
        temperatures.add(36.8);
        temperatures.add(38.2);
        
        int size = temperatures.size(); // get the number of elements in the list
        
        System.out.println("Number of temperatures: " + size);
    }
}