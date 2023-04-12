package 剑指Offer第2版;

class Solution {
    TreeNode res;
    int shen;
    boolean fh;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        dfs(root, p.val, q.val, 1);
        return res;
    }

    void dfs(TreeNode node, int i, int j, int k) {
        if (node == null) {
            return;
        }
        if (res == null && (node.val == i || node.val == j)) {
            res = node;
            shen = k;
        }
        if (shen < k && (node.val == i || node.val == j)) {
            fh = true;
            return;
        }
        dfs(node.left, i, j, k + 1);
        if (fh) {
            return;
        }
        if (shen > k) {
            res = node;
            shen = k;
        }
        if (res != null && shen == 1) {
            return;
        }
        dfs(node.right, i, j, k + 1);
    }
}
