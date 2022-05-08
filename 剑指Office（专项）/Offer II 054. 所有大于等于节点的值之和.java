class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        // 逆向中序遍历，更新结点值即可。
        sum += node.val;
        node.val = sum;
        dfs(node.left);
    }
}
