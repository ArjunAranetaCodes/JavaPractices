class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class Algorithm {
    TreeNode root;

    Algorithm() {
        root = null;
    }

    // Recursive method to perform Preorder traversal
    void preOrderTraversal(TreeNode node) {
        if (node != null) {
            // Process the current node
            System.out.print(node.data + " ");

            // Recur on the left subtree

        }
    }
}
