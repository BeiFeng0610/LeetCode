class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        TreeNode tmp = root;
        TreeNode l;
        while (!queue.isEmpty()) {
            tmp = queue.peek();
            l = tmp.left;
            tmp.left = tmp.right;
            tmp.right = l;
            queue.poll();
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        return root;
    }
}
