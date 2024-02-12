package desavitsky.binarytrees;

// Search in a Binary Search Tree
public class Task700 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val > root.val) {
                return searchBST(root.right, val);
            } else if (val < root.val) {
                return searchBST(root.left, val);
            } else return root;
        }
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}