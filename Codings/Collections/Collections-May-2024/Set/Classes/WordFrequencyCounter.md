## Problem: 
Implementing a Simple Word Frequency Counter

## Description: 
Create a program that demonstrates the use of Set to count the frequency of words in a sentence.

## Input:
Sentence: "Hello World, Hello Java, World Java"

## Output:
Hello: 2
World: 2
Java: 2

## Code Answer:
```Java
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String sentence = "Hello World, Hello Java, World Java";
        String[] words = sentence.split("\\s+");

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : uniqueWords) {
            int frequency = 0;
            for (String w : words) {
                if (word.equals(w)) {
                    frequency++;
                }
            }
            frequencyMap.put(word, frequency);
        }

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```

File Name: WordFrequencyCounter.java

This program demonstrates the use of Set to count the frequency of words in a sentence. The sentence is split into words, and a HashSet is used to get the unique words. Then, a HashMap is used to count the frequency of each word. Finally, the frequency map is printed to the console.