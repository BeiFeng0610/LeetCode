class BSTIterator {
    Queue<TreeNode> queue;
    TreeNode root = null;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        this.root = root;
        // 把所有结点都加入队列
        dfs(this.root);
    }

    public int next() {
        if (hasNext()) {
            return queue.poll().val;
        }
        return 0;
    }

    public boolean hasNext() {
        return queue.size() > 0;
    }

    // 中序遍历加入队列
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        queue.offer(node);
        dfs(node.right);
    }
}

class BSTIterator2 {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator2(TreeNode root) {
        cur = root;
        stack = new LinkedList<TreeNode>();
    }

    public int next() {
        // 当前结点不为null，就压栈，直到最左下结点。
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        // 然后弹出最左下结点。
        cur = stack.pop();
        int ret = cur.val;
        // 然后当前结点为右结点，如果右结点为空，则弹出父节点。
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
