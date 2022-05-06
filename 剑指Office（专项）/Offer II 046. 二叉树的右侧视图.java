class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            res.add(queue.getLast().val);
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
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode node, int depth){
        if(node == null) {
            return;
        }
        // 表示首次进入该层，该层预设为node.val
        if(res.size() == depth) {
            res.add(node.val);
        }
        res.set(depth, node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
