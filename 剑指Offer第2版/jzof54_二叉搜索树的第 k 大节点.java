package 剑指Offer第2版;

class Solution {
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = node.val;
        }
        dfs(node.left);

    }
}
