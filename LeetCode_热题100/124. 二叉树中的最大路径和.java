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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postorder(root);
        return max;
    }

    private int postorder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftNum = postorder(node.left);
        int rightNum = postorder(node.right);
        int res = Math.max(node.val + leftNum, node.val + rightNum);
        max = Math.max(max, node.val + leftNum + rightNum);
        return Math.max(res, 0);
    }
}