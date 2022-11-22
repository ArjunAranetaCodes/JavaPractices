public class Main {
    public static void main(String[] args) {
        int num = 1;

        do {
            System.out.println("Number: " + num);
            if (num == 3) {
                System.out.println("Breaking the loop at number 3");
                break;
            }
            num++;
        } while (num <= 5);
    }
}
