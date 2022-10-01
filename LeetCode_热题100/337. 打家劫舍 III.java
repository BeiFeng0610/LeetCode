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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] res = new int[2];

        int[] leftRob = dfs(node.left);
        int[] rightRob = dfs(node.right);
        // 不偷，就要俩儿子偷的最多的
        res[0] = Math.max(leftRob[0], leftRob[1]) + Math.max(rightRob[0], rightRob[1]);
        // 偷，就要俩儿子别偷
        res[1] = leftRob[0] + rightRob[0] + node.val;
        return res;
    }
}
