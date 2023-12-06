package desavitsky.trees;

// Delete Node in a BST
public class Task450 {

    private TreeNode findMin(TreeNode node) {
        if (node.left == null) return node;
        else return findMin(node.left);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                var min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else root.left = deleteNode(root.left, key);
        return root;
    }
}
