package desavitsky.trees;


import java.util.Arrays;

public class Task105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        else if (preorder.length == 1) return new TreeNode(preorder[0]);
        var root = new TreeNode(preorder[0]);
        var position = positionOf(inorder, root.val);
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, position + 1), Arrays.copyOfRange(inorder, 0, position)
        );
        root.right = buildTree(
                Arrays.copyOfRange(preorder, position + 1, preorder.length), Arrays.copyOfRange(inorder, position + 1, preorder.length)
        );

        return root;
    }

    private int positionOf(int[] arr, int el) {
        for (var i = 0; i < arr.length; i++) {
            if (arr[i] == el) return i;
        }
        return -1;
    }
}
