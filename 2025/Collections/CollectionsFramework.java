/**
 * Tutorial: Collections Framework Overview
 * Demonstrates different collection types
 */
import java.util.*;

public class CollectionsFramework {
    public static void main(String[] args) {
        // List - ordered, allows duplicates
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        System.out.println("ArrayList: " + arrayList);
        
        // Set - no duplicates
        Set<String> hashSet = new HashSet<>();
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("A");
        System.out.println("HashSet: " + hashSet);
        
        // Map - key-value pairs
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        System.out.println("HashMap: " + hashMap);
        
        // Queue - FIFO
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        System.out.println("Queue: " + queue);
        System.out.println("Poll: " + queue.poll());
        
        // Stack - LIFO
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        System.out.println("Stack: " + stack);
        System.out.println("Pop: " + stack.pop());
    }
}


















