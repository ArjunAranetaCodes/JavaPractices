import java.util.Arrays;
import java.util.List;

public class AllMatchExample5 {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(25.0, 30.5, 15.75, 40.2);

        boolean allBelowThreshold = prices.stream().allMatch(price -> price < 50.0);

        System.out.println("Are all prices below $50? " + allBelowThreshold);
    }
}
