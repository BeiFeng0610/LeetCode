class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    TreeNode treeNode = new TreeNode(-1);
    TreeNode tmp = treeNode;
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBiNode(root.left);
        treeNode.right = new TreeNode(root.val);
        treeNode = treeNode.right;
        convertBiNode(root.right);
        return tmp.right;
    }
}