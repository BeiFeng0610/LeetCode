class CBTInserter {

    TreeNode root;
    List<TreeNode> tree;
    int len = 0;
    
    // 初始化结点，统计初始树的结点数，放到list中，好随机访问
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
        // 计算父节点下标
        int par = (len - 1) / 2;
        TreeNode parNode = tree.get(par);
        // 判断父节点左右子树
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
