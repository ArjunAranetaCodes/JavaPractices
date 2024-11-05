# Problem: 
Rotate List

# Description: 
Write a Java program to rotate a list of elements to the right by a given number of steps.

# Input:
A list of integers: [1, 2, 3, 4, 5, 6, 7] <br/>

Number of steps to rotate: 3 <br/>

# Output:

Rotated list: [5, 6, 7, 1, 2, 3, 4]

# Answer:

```
import java.util.ArrayList;
import java.util.List;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        int steps = 3;

        List<Integer> rotatedList = rotate(list, steps);

        System.out.println("Original list: " + list);
        System.out.println("Rotated list: " + rotatedList);
    }

    public static <T> List<T> rotate(List<T> list, int steps) {
        int n = list.size();
        steps = steps % n;
        List<T> rotatedList = new ArrayList<>(list.subList(n - steps, n));
        rotatedList.addAll(list.subList(0, n - steps));
        return rotatedList;
    }
}
```