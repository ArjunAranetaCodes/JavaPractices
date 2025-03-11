# Problem: 
Find First Duplicate

# Description: 
Write a Java program to find the first duplicate in a list of integers.

# Input:

A list of integers: [2, 3, 4, 1, 2, 5, 3, 1]

# Output:
First duplicate: 2

# Answer:

```
import java.util.ArrayList;
import java.util.List;

public class FindFirstDuplicate {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(1);

        Integer firstDuplicate = findFirstDuplicate(list);

        System.out.println("First duplicate: " + firstDuplicate);
    }

    public static Integer findFirstDuplicate(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    return list.get(i);
                }
            }
        }
        return null;
    }
}
```

<p>
This program uses a nested loop to compare each element with the elements that follow it, and returns the first duplicate found. If no duplicates are found, it returns null.
</p>