class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class Algorithm {
    Node root;

    public Algorithm() {
        root = null;
    }

    // Method to insert a key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        // If the tree is empty, create a new node
        if (root == null) {
        }


    }

}
