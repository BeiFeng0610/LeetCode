class BSTIterator {
    Queue<TreeNode> queue;
    TreeNode root = null;


    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        this.root = root;
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
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
