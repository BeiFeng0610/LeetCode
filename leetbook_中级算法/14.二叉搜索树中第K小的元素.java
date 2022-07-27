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
    int ret = -1;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ret;
    }

    public void dfs(TreeNode node) {
        if (node == null || k == 0) {
            return;
        }

        dfs(node.left);
        if (--k == 0) {
            ret = node.val;
        }
        dfs(node.right);
    }
}