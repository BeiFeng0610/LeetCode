class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root);
        return flag;
    }

    private int dfs(TreeNode node) {
        if (node == null && !flag) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        if (Math.abs(l - r) > 1) {
            flag = false;
        }
        return Math.max(l, r) + 1;
    }
}