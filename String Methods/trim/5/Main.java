public class Main {
    public static void main(String[] args) {
        String str1 = "   Hello   ";
        String str2 = "   World   ";
        
        String trimmedConcatenation = str1.trim() + " " + str2.trim();
        
        System.out.println("Original String 1: '" + str1 + "'");
        System.out.println("Original String 2: '" + str2 + "'");
        System.out.println("Trimmed Concatenation: '" + trimmedConcatenation + "'");
    }
}
