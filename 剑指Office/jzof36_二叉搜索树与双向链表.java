package 剑指Office;

class Solution {
    Node pre;
    Node head;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (pre!= null) pre.right = node;
        else head = node;
        node.left = pre;
        pre = node;
        dfs(node.right);
    }
}
