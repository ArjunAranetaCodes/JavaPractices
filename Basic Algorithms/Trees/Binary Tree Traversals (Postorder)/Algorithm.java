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
        System.out.print(node.data + " ");
    }

    // Wrapper method to start postorder traversal from the root
    void startPostorderTraversal() {
        postorderTraversal(root);
    }

    // Driver method to test the Algorithm
    public static void main(String[] args) {
        Algorithm tree = new Algorithm();

        /*
         * Constructed binary tree is:
         *        1
         *       / \
         *      2   3
         *     / \
         *    4   5
         */
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Postorder traversal of binary tree:");
        tree.startPostorderTraversal();
    }
}
