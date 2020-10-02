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
            preOrderTraversal(node.left);

            // Recur on the right subtree
            preOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Algorithm tree = new Algorithm();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Preorder traversal of binary tree is: ");
        tree.preOrderTraversal(tree.root);
    }
}
