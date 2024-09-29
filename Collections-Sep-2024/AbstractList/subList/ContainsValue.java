import java.util.*;

public class ContainsValue {
    public static void main(String[] args) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u'); // create an unmodifiable list of vowels
        
        boolean isVowel = vowels.contains('e'); // check if the list contains the character 'e'
        
        System.out.println("Is 'e' a vowel? " + isVowel);
    }
}