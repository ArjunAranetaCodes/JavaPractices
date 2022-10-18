import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int sum = 0;
        int i = 0;
        do {
            int randomNumber = random.nextInt(10);
            System.out.println("Random Number: " + randomNumber);
            sum += randomNumber;
            i++;
        } while (i < 5);
        System.out.println("Sum of random numbers: " + sum); 
    }
}
