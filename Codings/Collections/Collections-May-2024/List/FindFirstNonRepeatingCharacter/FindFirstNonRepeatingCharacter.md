# Problem: 
"Find First Non-Repeating Character"

## Description: 
Write a Java program to find the first character that appears only once in a given string.

## Input:
A string: "aabbcdd"

## Output:
First non-repeating character: 'd'

## Answer:
```
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "aabbcdd";

        char firstNonRepeatingChar = findFirstNonRepeating(str);

        System.out.println("First non-repeating character: " + firstNonRepeatingChar);
    }

    public static char findFirstNonRepeating(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' '; // or any default value
    }
}
```
This program uses a LinkedHashMap to count the occurrences of each character in the string, and then finds the first character with a count of 1. The LinkedHashMap is used to preserve the order of characters.