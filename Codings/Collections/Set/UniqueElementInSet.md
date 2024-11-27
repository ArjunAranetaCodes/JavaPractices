# Problem Name: 
Unique Elements in Sets

# Description:

Write a program to find the unique elements in a collection of sets. Given a list of sets, find the elements that appear in only one set.

# Example:
[
  [1, 2, 3],
  [2, 3, 4],
  [3, 4, 5],
  [4, 5, 6]
]

# Output:
[1, 6]

# Code:
import java.util.*;

public class Main {
    public static Set<Integer> uniqueElements(List<Set<Integer>> sets) {
        // Create an empty set to store unique elements
        Set<Integer> unique = new HashSet<>();
        
        // Iterate over each set in the list
        for (Set<Integer> s : sets) {
            // Find the elements that appear only in this set
            Set<Integer> uniqueInS = new HashSet<>(s);
            for (Set<Integer> other : sets) {
                if (other != s) {
                    uniqueInS.removeAll(other);
                }
            }
            
            // Add these unique elements to the result set
            unique.addAll(uniqueInS);
        }
        
        return unique;
    }

    // Example usage:
    public static void main(String[] args) {
        List<Set<Integer>> sets = new ArrayList<>();
        sets.add(new HashSet<>(Arrays.asList(1, 2, 3)));
        sets.add(new HashSet<>(Arrays.asList(2, 3, 4)));
        sets.add(new HashSet<>(Arrays.asList(3, 4, 5)));
        sets.add(new HashSet<>(Arrays.asList(4, 5, 6)));
        
        System.out.println(uniqueElements(sets));  // Output: [1, 6]
    }
}