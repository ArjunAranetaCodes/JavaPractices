public class Main {
    public static void main(String[] args) {
        double[] numbers = {4.2, 8.7, 6.1, 5.5};
        
        System.out.println("Ceil values in the array:");
        for (double num : numbers) {
            double ceilValue = Math.ceil(num);
            System.out.println("Ceil value of " + num + " is: " + ceilValue);
        }
    }
}
