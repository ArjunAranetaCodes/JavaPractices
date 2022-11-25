public class Main {
    public static void main(String[] args) {
        int count = 0;

        while (count < 5) {
            System.out.println("Count: " + count);
            if (count == 2) {
                System.out.println("Breaking the loop at count 2");
                break;
            }
            count++;
        }
    }
}
