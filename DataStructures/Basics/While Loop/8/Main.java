public class Main {
    public static void main(String[] args) {
        int num = 17;
        boolean isPrime = true;
        int i = 2;
        while (i <= num / 2) {
            if (num % i == 0) {
                isPrime = false;
            }
        }

        System.out.println(num + " is prime: " + isPrime);
    }
}
