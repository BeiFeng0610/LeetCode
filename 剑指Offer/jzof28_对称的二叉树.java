package 剑指Offer;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || DFS(root.left, root.right);
    }

    boolean DFS(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null || l.val != r.val) {

            return false;
        }
        return DFS(l.left, r.right) && DFS(l.right, r.left);
    }
}
