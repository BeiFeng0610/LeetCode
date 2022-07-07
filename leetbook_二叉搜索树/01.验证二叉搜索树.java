import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
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

class Solution {
    TreeNode pre;
    private boolean tag = true;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return tag;
    }

    private boolean dfs(TreeNode node) {
        if (!tag || node == null) {
            return tag;
        }
        dfs(node.left);
        if (pre != null && pre.val >= node.val) {
            tag = false;
        }
        pre = node;
        dfs(node.right);
        return tag;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * @param node 当前结点
     * @param lower 下界 初始化为 Long.MIN_VALUE
     * @param upper 上界 初始化为 Long.MAX_VALUE
     * @return boolean
     */
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        /**
         *  判断当前结点的，左或右子树
         *      左：把当前结点定位上界
         *      右：把当前结点定位下界
         */
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
