public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            switch (i) {
                case 1:
                    System.out.println("Processing case 1");
                    break;
                case 2:
                    System.out.println("Skipping case 2");
                    continue;
                case 3:
                    System.out.println("Processing case 3");
                    break;
            }
        }
    }
}
