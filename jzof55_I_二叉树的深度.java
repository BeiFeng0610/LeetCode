class Solution {
    int shen = 0, max = 0;
    
    public int maxDepth(TreeNode root) {
        dfs(root);
        return max;
    }
    
    public void dfs(TreeNode node){
        if (node == null) {
            return;
        }
        shen++;
        max = Math.max(max, shen);
        dfs(node.left);
        dfs(node.right);
        shen--;
    }
}
