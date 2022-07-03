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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum);
    }

    private boolean dfs(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return sum == node.val;
        }
        return dfs(node.left, sum - node.val) || dfs(node.right, sum - node.val);
    }
}


