class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }

        TreeNode tmp = root;
        while (tmp != null) {
            if (val == tmp.val) {
                return tmp;
            }
            tmp = val < tmp.val ? tmp.left : tmp.right;
        }
        return null;
    }
}