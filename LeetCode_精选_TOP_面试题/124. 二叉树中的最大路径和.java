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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);
        int res = Math.max(node.val + leftMax, node.val + rightMax);
        max = Math.max(max, node.val + leftMax + rightMax);
        return Math.max(0, res);
    }
}