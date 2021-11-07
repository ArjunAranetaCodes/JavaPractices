public class Main {
    public static void main(String[] args) {
        String str = "Java Programming";
        
        // Case-insensitive check if the string starts with "java"
        if (str.toLowerCase().startsWith("java")) {
            System.out.println("The string starts with 'java' (case-insensitive)");
        } else {
            System.out.println("The string does not start with 'java'");
        }
    }
}
 