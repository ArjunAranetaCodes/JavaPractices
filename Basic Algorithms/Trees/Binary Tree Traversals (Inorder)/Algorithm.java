class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class Algorithm {
    // Root of the Binary Tree
    TreeNode root;

    public Algorithm() {
        root = null;
    }

    // Inorder traversal of the tree
    private void inorderTraversal(TreeNode node) {
        if (node != null) {
            // Traverse the left subtree
            inorderTraversal(node.left);

            // Visit the root node
            System.out.print(node.val + " ");

            // Traverse the right subtree
            inorderTraversal(node.right);
        }
    }

    // Helper method to start the inorder traversal from the root
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    // Driver method to test the Algorithm class
    public static void main(String[] args) {
        Algorithm tree = new Algorithm();

        /* Constructed binary tree is:
                   1
                 /   \
                2     3
               / \
              4   5
        */

        tree.root = new TreeNode(1);

    }
}
