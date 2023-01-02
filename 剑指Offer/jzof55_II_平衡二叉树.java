package 剑指Offer;

class Solution {
    boolean tag = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return tag;
    }

    public int dfs(TreeNode node){
        if (!tag || node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        if (l - r > 1 || l - r < -1) {
            tag =  false;
        }
        return Math.max(l, r) + 1;
    }
}
