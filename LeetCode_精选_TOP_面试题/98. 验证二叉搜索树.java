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
    TreeNode pre;
    boolean tag = true;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return tag;
    }

    public boolean dfs(TreeNode node) {
        if (!tag || node == null) {
            return tag;
        }
        dfs(node.left);
        if (pre != null && pre.val >= node.val) {
            tag = false;
        }
        pre = node.left;
        dfs(node.right);
        return true;
    }
}


class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (min >= node.val || node.val >= max) {
            return false;
        }
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}