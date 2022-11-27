public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i);
            if (i == 3) {
                System.out.println("Breaking the loop at iteration 3");
                break; 
            }
        }
    }
}
