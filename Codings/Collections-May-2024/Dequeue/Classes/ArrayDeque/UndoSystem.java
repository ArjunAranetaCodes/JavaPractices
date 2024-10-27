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