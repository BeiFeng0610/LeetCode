class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int curlen = queue.size();
            for (int i = 0; i < curlen; i++) {
                TreeNode tmp = queue.poll();
                max = Math.max(max, tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            res.add(max);
        }

        return res;
    }
}

class Solution2 {
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode node, int depth){
        if(node == null) {
            return;
        }
        if(res.size() == depth) { // 表示首次进入该层，该层最大值预设为node.val
            res.add(node.val);
        }
        res.set(depth, Math.max(res.get(depth), node.val)); // #1 利用当前结点的层号信息，更新所属层的最大值
        dfs(node.left, depth + 1); // #2
        dfs(node.right, depth + 1); // #3
    }
}
