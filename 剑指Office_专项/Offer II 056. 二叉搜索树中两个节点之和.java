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
        // 如果set集合中存在 k-node.val 结点则返回true
        if (set.contains(k - node.val)) {
            return true;
        }
        // 不存在则加入set
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
            // 结点弹出，判断 k - node.val 值是否存在set，判断返回
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
