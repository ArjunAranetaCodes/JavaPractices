# Problem: 
Merge Two Sorted Lists

# Description: 
Write a Java program to merge two sorted lists into one sorted list.

# Input:
List 1: [1, 3, 5, 7]
List 2: [2, 4, 6, 8]

# Output:
Merged list: [1, 2, 3, 4, 5, 6, 7, 8]

# Answer:

```
import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);

        List<Integer> mergedList = merge(list1, list2);

        System.out.println("Merged list: " + mergedList);
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }
        return mergedList;
    }
}
```

<p>
This program uses a simple iteration and comparison to merge the two sorted lists into one sorted list.
</p>