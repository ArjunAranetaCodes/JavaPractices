public class Main {
    public static void main(String[] args) {
        int number = 7;
        String result = checkEvenOdd(number);
        System.out.println(result);
    }

    static String checkEvenOdd(int num) {
        return (num % 2 == 0) ? "Even" : "Odd";
    }
}
  