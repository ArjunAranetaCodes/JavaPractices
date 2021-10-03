public class Main {
    public static void main(String[] args) {
        String[] words = {"   Apple  ", "Banana  ", "   Orange"};
        
        System.out.println("Original Array:");
        for (String word : words) {
            System.out.println("'" + word + "'");
        }
        
        System.out.println("\nTrimmed Array:");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim();
            System.out.println("'" + words[i] + "'");
        }
    }
}
   