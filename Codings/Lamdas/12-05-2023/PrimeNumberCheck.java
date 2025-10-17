import java.util.function.Predicate;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        Predicate<Integer> isPrime = n -> {
            if (n <= 1) return false;
            if (n <= 3) return true;
            if (n % 2 == 0 || n % 3 == 0) return false;
            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) return false;
            }
            return true;
        };

        int number = 17; // Change to test different numbers
        boolean prime = isPrime.test(number);

        System.out.println(number + " is prime: " + prime);
    }
}
