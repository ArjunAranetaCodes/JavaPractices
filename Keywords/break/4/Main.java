public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Outer loop iteration " + i);

            for (int j = 1; j <= 3; j++) {
                System.out.println("Inner loop iteration " + j);

                if (i + j == 4) {
                    System.out.println("Breaking both loops at total " + (i + j));
                }
            }
        }
    }
}
