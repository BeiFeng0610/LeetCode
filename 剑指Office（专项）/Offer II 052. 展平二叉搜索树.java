class Solution {
    TreeNode pre = null;
    public TreeNode increasingBST(TreeNode root) {
        // 创建一个前置结点
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
        // 前置结点的右子树指向当前结点，当前结点，左子树置空。
        pre.right = node;
        node.left = null;
        // 更新前置结点
        pre = node;
        dfs(node.right);
    }
}
