package LeetCode;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return list;
    }

    void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        } else {
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }
    }
}
