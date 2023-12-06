package desavitsky.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// Binary Tree Level Order Traversal
public class Task102 {

    public static void main(String[] args) {
        var nine = new TreeNode(9);
        var ft = new TreeNode(15);
        var seven = new TreeNode(7);
        var tw = new TreeNode(20, ft, seven);

        var root = new TreeNode(3, nine, tw);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        var queue = new ArrayDeque<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current;
            var level = new ArrayList<Integer>(queue.size());
            var currentSize = queue.size();
            for (var i = 0; i < currentSize; i++){
                current = queue.pop();
                level.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            res.add(level);
        }
        return res;
    }
}
