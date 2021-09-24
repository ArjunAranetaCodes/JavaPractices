public class Main {
    public static void main(String[] args) {
        String numbers = "10 20 30 40 50";
        String[] numberArray = numbers.split(" ");
        
        int sum = 0;
        for (String num : numberArray) {
            sum += Integer.parseInt(num);
        }
        
        System.out.println("Sum of numbers: " + sum);
    }
}
   