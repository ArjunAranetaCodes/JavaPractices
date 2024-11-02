# Problem: 
Stack Class Methods Demonstration

## Description: 
Create a program that demonstrates the various methods of the Stack class in Java, including push, pop, peek, empty, and search.

## Input: 
None

## Output:

```
Initial Stack: []
Stack after pushing 10: [10]
Stack after pushing 20: [10, 20]
Stack after pushing 30: [10, 20, 30]
Popped element: 30
Stack after popping: [10, 20]
Peek element: 20
Stack is empty: false
Search 20: 1
Stack is empty after clearing: true
```
## Code Answer:

```java
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("Initial Stack: " + stack);

        // Push elements
        stack.push(10);
        System.out.println("Stack after pushing 10: " + stack);
        stack.push(20);
        System.out.println("Stack after pushing 20: " + stack);
        stack.push(30);
        System.out.println("Stack after pushing 30: " + stack);

        // Pop element
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after popping: " + stack);

        // Peek element
        System.out.println("Peek element: " + stack.peek());

        // Check if stack is empty
        System.out.println("Stack is empty: " + stack.empty());

        // Search element
        System.out.println("Search 20: " + stack.search(20));

        // Clear stack
        stack.clear();
        System.out.println("Stack is empty after clearing: " + stack.empty());
    }
}
```

This program creates a Stack, pushes elements, pops an element, peeks the top element, checks if the Stack is empty, searches for an element, and finally clears the Stack. The output demonstrates the result of each operation.