## Problem: 
Implementing a SimpleUndoSystem

## Description: 
Create a program that demonstrates the use of ArrayDeque to implement a simple undo system. The program should allow users to perform actions and then undo those actions.

## Input:
User: Action 1

User: Action 2

User: Undo

User: Action 3

User: Undo
## Output:
Action 1 performed

Action 2 performed

Action 2 undone

Action 3 performed

Action 3 undone

## Code Answer:
```Java
import java.util.ArrayDeque;
import java.util.Deque;

public class UndoSystem {
private Deque<String> actionQueue = new ArrayDeque<>();

    public void performAction(String action) {
        actionQueue.addLast(action);
        System.out.println(action + " performed");
    }

    public void undoAction() {
        if (!actionQueue.isEmpty()) {
            String action = actionQueue.pollLast();
            System.out.println(action + " undone");
        }
    }

    public static void main(String[] args) {
        UndoSystem undoSystem = new UndoSystem();

        undoSystem.performAction("Action 1");
        undoSystem.performAction("Action 2");
        undoSystem.undoAction();
        undoSystem.performAction("Action 3");
        undoSystem.undoAction();
    }
}
```

File Name: UndoSystem.java

This program demonstrates the use of ArrayDeque to implement a simple undo system. Users can perform actions, and then undo those actions using the undoAction method. The ArrayDeque is used to keep track of the actions, and the pollLast method is used to remove and return the last action in the queue when the user wants to undo an action.