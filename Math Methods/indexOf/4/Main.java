public class Main {
    public static void main(String[] args) {
        String str = "Java is fun and Java is powerful";
        String target = "Java";
        int index = str.indexOf(target, 10); // Start searching from index 10
        System.out.println("Index of '" + target + "' (starting from index 10): " + index);
    }
}
   