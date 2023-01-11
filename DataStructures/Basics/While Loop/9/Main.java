public class Main {
    public static void main(String[] args) {
        int num = 98765;
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        System.out.println("Number of digits: " + count);
    }
}
