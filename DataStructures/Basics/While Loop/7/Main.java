public class Main {
    public static void main(String[] args) {
        int n = 8;
        int first = 0, second = 1;
        int i = 1;
        while (i <= n) {
            System.out.println(first);
            int next = first + second;
            first = second;
            second = next;
        }
    }
}
