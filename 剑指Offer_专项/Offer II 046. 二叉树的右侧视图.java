class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 记录每层最后一个结点
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
        // 深度搜索，优先遍历右子树，每进新的一层都是最右边结点
        if(res.size() == depth) {
            res.add(node.val);
        }
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}
