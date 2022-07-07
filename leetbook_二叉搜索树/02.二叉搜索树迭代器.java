import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {

    private int idx;
    private List<Integer> list;

    public BSTIterator(TreeNode root) {
        idx = 0;
        list = new ArrayList<>();
        initList(root);
    }

    public int next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < list.size();
    }

    /**
     * 一次性把所有结点，中序遍历一遍，全部加到数组中
     * @param node
     */
    private void initList(TreeNode node) {
        if (node == null) {
            return;
        }
        initList(node.left);
        list.add(node.val);
        initList(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

class BSTIterator {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new LinkedList<TreeNode>();
    }

    /**
     * 中序遍历，先压栈找到遍历到的下一个结点，
     * 相当于调用一次 next 就和 while 循环中（迭代版的中序遍历） 循环一遍一样。
     * @return
     */
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