class CBTInserter {

    TreeNode root;
    List<TreeNode> tree;
    int len = 0;

    public CBTInserter(TreeNode root) {
        this.root = root;
        tree = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        tree.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp.left != null) {
                queue.offer(tmp.left);
                tree.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
                tree.add(tmp.right);
            }
        }
        len = tree.size();
    }

    public int insert(int v) {
        int par = (len - 1) / 2;
        TreeNode parNode = tree.get(par);
        if (parNode.left == null) {
            parNode.left = new TreeNode(v);
            tree.add(parNode.left);
        } else {
            parNode.right = new TreeNode(v);
            tree.add(parNode.right);
        }
        len++;
        return parNode.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
