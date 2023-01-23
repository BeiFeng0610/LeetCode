class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    private long preVal = Long.MIN_VALUE;
    private boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null || !flag) {
            return true;
        }
        isValidBST(root.left);
        if (root.val <= preVal || !flag) {
            flag = false;
            return false;
        }
        preVal = root.val;
        isValidBST(root.right);
        return flag;
    }
}