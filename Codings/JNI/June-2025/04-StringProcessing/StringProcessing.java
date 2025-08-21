public class StringProcessing {
    // Load the native library
    static {
        try {
            System.loadLibrary("StringProcessing");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native library 'StringProcessing' not found.");
            System.err.println("Please ensure the library is compiled and in the library path.");
            System.exit(1);
        }
    }

    // Native method declarations for string processing
    public native String reverse(String str);
    public native String toUpperCase(String str);
    public native String toLowerCase(String str);
    public native int countWords(String str);
    public native int countCharacters(String str);
    public native int countVowels(String str);
    public native int countConsonants(String str);
    public native boolean isPalindrome(String str);
    public native String removeSpaces(String str);
    public native String[] split(String str, String delimiter);
    public native String replace(String str, String oldStr, String newStr);
    public native boolean contains(String str, String substring);
    public native int findFirst(String str, String substring);
    public native int findLast(String str, String substring);
    public native String substring(String str, int start, int end);
    public native String trim(String str);
    public native boolean startsWith(String str, String prefix);
    public native boolean endsWith(String str, String suffix);
    public native String[] extractWords(String str);
    public native String removeSpecialCharacters(String str);

    public static void main(String[] args) {
        System.out.println("=== JNI String Processing Demo ===");
        
        StringProcessing strProc = new StringProcessing();
        
        // Test 1: Basic string operations
        System.out.println("\n1. Basic String Operations:");
        String testStr = "Hello World!";
        System.out.println("Original: " + testStr);
        System.out.println("Reversed: " + strProc.reverse(testStr));
        System.out.println("Uppercase: " + strProc.toUpperCase(testStr));
        System.out.println("Lowercase: " + strProc.toLowerCase(testStr));
        
        // Test 2: Character counting
        System.out.println("\n2. Character Analysis:");
        String text = "The quick brown fox jumps over the lazy dog.";
        System.out.println("Text: " + text);
        System.out.println("Total characters: " + strProc.countCharacters(text));
        System.out.println("Word count: " + strProc.countWords(text));
        System.out.println("Vowels: " + strProc.countVowels(text));
        System.out.println("Consonants: " + strProc.countConsonants(text));
        
        // Test 3: Palindrome test
        System.out.println("\n3. Palindrome Tests:");
        String[] palindromes = {"racecar", "level", "hello", "A man a plan a canal Panama"};
        for (String pal : palindromes) {
            System.out.printf("'%s' is %s\n", pal, strProc.isPalindrome(pal) ? "a palindrome" : "not a palindrome");
        }
        
        // Test 4: String manipulation
        System.out.println("\n4. String Manipulation:");
        String messyStr = "  Hello   World  !  ";
        System.out.println("Original: '" + messyStr + "'");
        System.out.println("Trimmed: '" + strProc.trim(messyStr) + "'");
        System.out.println("No spaces: '" + strProc.removeSpaces(messyStr) + "'");
        
        // Test 5: String splitting and joining
        System.out.println("\n5. String Splitting:");
        String csvData = "apple,banana,cherry,date,elderberry";
        System.out.println("CSV data: " + csvData);
        String[] fruits = strProc.split(csvData, ",");
        System.out.println("Split result:");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("  [" + i + "]: " + fruits[i]);
        }
        
        // Test 6: String replacement
        System.out.println("\n6. String Replacement:");
        String sentence = "The cat sat on the mat. The cat is black.";
        System.out.println("Original: " + sentence);
        String replaced = strProc.replace(sentence, "cat", "dog");
        System.out.println("Replaced: " + replaced);
        
        // Test 7: String searching
        System.out.println("\n7. String Searching:");
        String haystack = "Hello world, hello universe, hello galaxy";
        String needle = "hello";
        System.out.println("Text: " + haystack);
        System.out.println("Searching for: " + needle);
        System.out.println("Contains: " + strProc.contains(haystack, needle));
        System.out.println("First occurrence at: " + strProc.findFirst(haystack, needle));
        System.out.println("Last occurrence at: " + strProc.findLast(haystack, needle));
        
        // Test 8: Substring operations
        System.out.println("\n8. Substring Operations:");
        String longText = "This is a very long text for testing substring operations";
        System.out.println("Text: " + longText);
        System.out.println("Substring(5, 15): " + strProc.substring(longText, 5, 15));
        
        // Test 9: Prefix and suffix checking
        System.out.println("\n9. Prefix and Suffix:");
        String testWord = "programming";
        System.out.println("Word: " + testWord);
        System.out.println("Starts with 'pro': " + strProc.startsWith(testWord, "pro"));
        System.out.println("Ends with 'ing': " + strProc.endsWith(testWord, "ing"));
        System.out.println("Starts with 'java': " + strProc.startsWith(testWord, "java"));
        
        // Test 10: Word extraction
        System.out.println("\n10. Word Extraction:");
        String complexText = "Hello, World! This is a test. It has punctuation, numbers (123), and symbols @#$%.";
        System.out.println("Complex text: " + complexText);
        String[] words = strProc.extractWords(complexText);
        System.out.println("Extracted words:");
        for (int i = 0; i < words.length; i++) {
            System.out.println("  [" + i + "]: " + words[i]);
        }
        
        // Test 11: Special character removal
        System.out.println("\n11. Special Character Removal:");
        String specialText = "Hello@World!#$%^&*()_+-=[]{}|;':\",./<>?";
        System.out.println("With special chars: " + specialText);
        System.out.println("Clean text: " + strProc.removeSpecialCharacters(specialText));
        
        // Test 12: Performance comparison
        System.out.println("\n12. Performance Comparison:");
        String longString = "This is a very long string that we will use to test performance. ".repeat(1000);
        
        long startTime, endTime;
        
        // Test reverse performance
        startTime = System.nanoTime();
        String reversed = strProc.reverse(longString);
        endTime = System.nanoTime();
        long nativeTime = endTime - startTime;
        
        startTime = System.nanoTime();
        String javaReversed = new StringBuilder(longString).reverse().toString();
        endTime = System.nanoTime();
        long javaTime = endTime - startTime;
        
        System.out.printf("Native reverse: %d ns, Java reverse: %d ns\n", nativeTime, javaTime);
        System.out.printf("Native is %.2fx %s\n", 
            (double)Math.max(nativeTime, javaTime) / Math.min(nativeTime, javaTime),
            nativeTime < javaTime ? "faster" : "slower");
        
        // Test word counting performance
        startTime = System.nanoTime();
        int nativeWordCount = strProc.countWords(longString);
        endTime = System.nanoTime();
        nativeTime = endTime - startTime;
        
        startTime = System.nanoTime();
        int javaWordCount = longString.split("\\s+").length;
        endTime = System.nanoTime();
        javaTime = endTime - startTime;
        
        System.out.printf("Native word count: %d ns, Java word count: %d ns\n", nativeTime, javaTime);
        System.out.printf("Native is %.2fx %s\n", 
            (double)Math.max(nativeTime, javaTime) / Math.min(nativeTime, javaTime),
            nativeTime < javaTime ? "faster" : "slower");
        
        System.out.println("\n=== JNI String Processing Demo Complete ===");
    }
} 