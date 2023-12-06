package desavitsky.trees;

import java.util.Stack;

//Kth Smallest Element in a BST
public class Task230 {
    public int kthSmallest(TreeNode root, int k) {
        var stack = new Stack<TreeNode>();
        var curr = root;
        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            k--;
            if (k == 0) return curr.val;
            curr = curr.right;
        }
        return 0;
    }

}
