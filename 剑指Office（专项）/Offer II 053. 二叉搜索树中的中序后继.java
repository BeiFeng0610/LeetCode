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
        // 返回结点为空，且找到第一个大于p结点的结点，赋值即可，然后直接返回
        if (res == null && node.val > p.val) {
            res = node;
            return;
        } else if (res != null) {
            return;
        }
        dfs(node.right, p);
    }
}
