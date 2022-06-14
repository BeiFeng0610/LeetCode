class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    // 每个结点的最大贡献
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 计算左右子节点的最大贡献
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 因为需要连续，结点的最大贡献值只可能，0 curr 右、左 curr 0、左 curr 右
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新最大的结点和。
        maxSum = Math.max(maxSum, priceNewpath);
        // 有种情况是把当前的和 和父节点 相加，需要带走一个左节点或者右结点，带走更大的那一个。
        return node.val + Math.max(leftGain, rightGain);
    }
}
