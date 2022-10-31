public class Main {
    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
            i++;
            if (i == 2 || i == 4) {
                System.out.println("Skipping iteration " + i);
                continue;
            }
        }
    }
}
