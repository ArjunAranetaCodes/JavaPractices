public class Main {
    public static void main(String[] args) {
        outerLoop:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) {
                    System.out.println("Skipping inner loop iteration " + j + " in outer loop " + i);
                    continue;
                }
        }
    }
}
