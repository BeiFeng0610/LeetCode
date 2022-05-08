class Solution {
    TreeNode pre = null;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(-1);
        pre = res;
        dfs(root);
        return res.right;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        pre.right = node;
        node.left = null;
        pre = node;
        dfs(node.right);
    }
}
