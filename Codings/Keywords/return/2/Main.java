public class Main {
    public static void main(String[] args) {
        int maxNumber = findMax(8, 12);
        System.out.println("Maximum Number: " + maxNumber);
    }

    static int findMax(int num1, int num2) {
        return (num1 > num2) ? num1 : num2;
    }
}
