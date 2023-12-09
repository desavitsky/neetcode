package desavitsky.trees;

// Path Sum
public class Task112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathSumCurrent(root, targetSum, 0);
    }

    public boolean hasPathSumCurrent(TreeNode root, int target, int current) {
        if (root == null) return false;
        var updatedCurrent = current + root.val;
        if (root.left == null && root.right == null) return updatedCurrent == target;
        return hasPathSumCurrent(root.left, target, updatedCurrent) ||
                hasPathSumCurrent(root.right, target, updatedCurrent);

    }

}
