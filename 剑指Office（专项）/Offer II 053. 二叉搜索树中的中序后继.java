class Solution {
    TreeNode pre = null;
    TreeNode res = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return res;
    }

    public void dfs(TreeNode node, TreeNode p) {
        if (node == null || res != null) {
            return;
        }
        dfs(node.left, p);
        /*if (pre != null) {
            res = node;
            return;
        }
        if (node.val == p.val) {
            pre = node;
        }*/
        if (res == null && node.val > p.val) {
            res = node;
            return;
        } else if (res != null) {
            return;
        }
        dfs(node.right, p);
    }
}
