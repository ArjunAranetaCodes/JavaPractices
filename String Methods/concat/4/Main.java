public class Main {
    public static void main(String[] args) {
        String[] words = {"This", "is", "a", "concatenation", "example"};
        String result = "";
        
        for (String word : words) {
            result = result.concat(word + " ");
        }
        
        System.out.println("Concatenated Result: " + result.trim());
    }
}
