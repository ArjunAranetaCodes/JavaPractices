public class Main {
    public static void main(String[] args) {
        int i = 0;
        do {
            i++;
            if (i == 3) {
                System.out.println("Skipping iteration " + i);
                continue;
            }
            System.out.println("Executing iteration " + i);
        } while (i < 5);
    }
}
