public class Main {
    public static void main(String[] args) {
        int n = 10;
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("Sum of numbers from 1 to " + n + " is: " + sum);
    }
}
