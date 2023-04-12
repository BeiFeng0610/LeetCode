class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int preSum){
        if (node == null) {
            return 0;
        }
        // 得出前一个结点和当前结点的组合值
        int sum = preSum * 10 + node.val;
        // 如果当前结点为叶子结点，则返回值进行累加
        if (node.left == null && node.right == null) {
            return sum;
        } else {
            // 如果不是叶子结点，就去获取子节点的值。
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }
}

class Solution2 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // 结点队列
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        // 值队列
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            // 弹出队头，获取值
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            // 如果是叶子结点，就累加。
            if (left == null && right == null) {
                sum += num;
            } else {
                // 不是叶子结点，就把子节点加入队列，把组合值加入值队列
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}
