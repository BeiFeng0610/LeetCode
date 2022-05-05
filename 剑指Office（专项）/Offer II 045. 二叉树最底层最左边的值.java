class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = root.val;
        while (!queue.isEmpty()) {
            // 记录每层的第一个结点
            res = queue.peek().val;
            int curlen = queue.size();
            for (int i = 0; i < curlen; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }
        return res;
    }
}

class Solution2 {
    int res = 0;
    int maxDepth = 0;
    public int findBottomLeftValue(TreeNode root) {
        this.res = root.val;
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode node, int depth){
        if(node == null) {
            return;
        }
        // 表示进入新的一层，而且是最左结点
        if(maxDepth < depth) {
            maxDepth = depth;
            res = node.val;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
