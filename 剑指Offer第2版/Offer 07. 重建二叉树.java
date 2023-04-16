import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int idx = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preval = preorder[i];
            TreeNode peek = stack.peek();
            if (peek.val != inorder[idx]) {
                peek.left = new TreeNode(preval);
                stack.push(peek.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[idx]) {
                    peek = stack.pop();
                    idx++;
                }
                peek.right = new TreeNode(preval);
                stack.push(peek.right);
            }
        }
        return root;
    }
}
