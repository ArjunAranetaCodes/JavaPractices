public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("OpenAI is amazing!");
        
        // Check if the StringBuilder content starts with "Open"
        if (stringBuilder.toString().startsWith("Open")) {
            System.out.println("The StringBuilder content starts with 'Open'");
        } else {
            System.out.println("The StringBuilder content does not start with 'Open'");
        }
    }
}
   