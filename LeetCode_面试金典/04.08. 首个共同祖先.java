class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    public boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean lb = helper(node.left, p, q);
        boolean rb = helper(node.right, p, q);
        if ((lb && rb) || ((node == p || node == q) && (lb || rb))) {
            res = node;
        }
        return lb || rb || (node == p || node == q);
    }
}