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
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root, pre = null;
        while (cur != null && cur.val != key) {
            pre = cur;
            cur = cur.val < key ? cur.right : cur.left;
        }
        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            cur = null;
        } else if (cur.left == null) {
            cur = cur.right;
        } else if (cur.right == null) {
            cur = cur.left;
        } else {
            TreeNode tPre = cur;
            TreeNode tmp = cur.right;
            while (tmp.left != null) {
                tPre = tmp;
                tmp = tmp.left;
            }
            if (tPre.val == cur.val) {
                tPre.right = tmp.right;
            } else {
                tPre.left = tmp.right;
            }
            tmp.left = cur.left;
            tmp.right = cur.right;
            cur = tmp;
        }
        if (pre == null) {
            return cur;
        } else {
            if (pre.left != null && pre.left.val == key) {
                pre.left = cur;
            } else {
                pre.right = cur;
            }
        }
        return root;
    }
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        /**
         * 直接递归查找到需要删除的结点
         * 如果没有结点，直接返回null
         * 左空，返回右，右空返回左。
         * 都不空，就开始找到中序遍历的下一个结点
         * 然后从当前结点去找到下一节点，然后删除（断开连接）
         * 然后把中序下一结点，覆盖需要删除的结点
         */
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}