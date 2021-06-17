public class Main {
    public static void main(String[] args) {
        int num1 = 7, num2 = 12, num3 = 5;
        int max = Math.max(Math.max(num1, num2), num3);
        System.out.println("Maximum value among " + num1 + ", " + num2 + ", and " + num3 + ": " + max);
    }
}
 