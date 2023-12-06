package desavitsky.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// Binary Tree Level Order Traversal
public class Task199 {

    public static void main(String[] args) {
        var nine = new TreeNode(9);
        var ft = new TreeNode(15);
        var seven = new TreeNode(7);
        var tw = new TreeNode(20, ft, seven);

        var root = new TreeNode(3, nine, tw);
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();
        var queue = new ArrayDeque<TreeNode>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = null;
            var currentSize = queue.size();
            for (var i = 0; i < currentSize; i++) {
                current = queue.pop();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);

            }
            res.add(current.val);
        }
        return res;
    }
}
