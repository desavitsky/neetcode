package desavitsky.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Binary Tree Inorder Traversal
public class Task94 {
    // recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>  list = new ArrayList<>();
        if (root == null) return list;
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    // DFS using stack
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer>  list = new ArrayList<>();
        Stack<TreeNode> dfsStack = new Stack<>();
        var curr = root;

        while (curr != null || !dfsStack.isEmpty()) {

            while (curr != null) {
                dfsStack.push(curr);
                curr = curr.left;
            }
            curr = dfsStack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }


}
