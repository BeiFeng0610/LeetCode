class Solution {
    Set<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();

        return dfs(root, k);
    }

    public boolean dfs(TreeNode node, int k) {
        if (node == null) {
            return false;
        }
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return dfs(node.left, k)||dfs(node.right, k);
    }
}
class Solution2 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }
}
