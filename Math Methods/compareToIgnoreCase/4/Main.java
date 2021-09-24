public class Main {
    public static void main(String[] args) {
        String str1 = "OpenAI";
        String str2 = "openai";
        
        if (str1.compareToIgnoreCase(str2) == 0) {
            System.out.println("Strings are equal ignoring case.");
        } else {
            System.out.println("Strings are not equal ignoring case.");
        }
    }
}
