class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        /**
         * 当前深度满足，而且，左右子树也必须满足
         */
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }
}