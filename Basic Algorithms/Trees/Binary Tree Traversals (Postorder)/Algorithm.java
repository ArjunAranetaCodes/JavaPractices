class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class Algorithm {
    // Root of the Binary Tree
    TreeNode root;

    Algorithm() {
        root = null;
    }

    // Method to perform postorder traversal
    void postorderTraversal(TreeNode node) {
        if (node == null)
            return;

        // Traverse the left subtree
        postorderTraversal(node.left);

        // Traverse the right subtree
        postorderTraversal(node.right);

        // Visit the node
    }


}
