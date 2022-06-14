package 剑指Office;

/*
*   例如满二叉树 1 23 4567
*   双端队列
*       单数行从队头弹出：
*           遍历弹出结点加入其 左子树 右子树 至队尾
*       双数行从队尾弹出：
*           遍历弹出结点加入其 右子树 左子树 至队头
*   如：单数行
*           弹出1  加入23
*      双数行
*           弹出3 从队头加入7 6
*           弹出2 加入 5 4
*           此时对内元素为  4567
* */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                if (res.size() % 2 == 0) {
                    TreeNode node = queue.removeFirst();
                    tmp.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                } else {
                    TreeNode node = queue.removeLast();
                    tmp.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
