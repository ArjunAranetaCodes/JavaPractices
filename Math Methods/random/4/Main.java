import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int arraySize = 5;
        int[] randomArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            randomArray[i] = random.nextInt(50); // Generates random integers between 0 (inclusive) and 50 (exclusive)
        }

        System.out.print("Random Array: ");
        for (int num : randomArray) {
            System.out.print(num + " ");
        } 
    }
}
