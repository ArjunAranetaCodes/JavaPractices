public class Main {
    public static void main(String[] args) {
        String values = "5 12 8 24 17";
        String[] valueArray = values.split(" ");
        
        int max = Integer.MIN_VALUE;
        for (String val : valueArray) {
            int current = Integer.parseInt(val);
            if (current > max) {
                max = current;
            }
        }
        
        System.out.println("Maximum value: " + max);
    }
}
