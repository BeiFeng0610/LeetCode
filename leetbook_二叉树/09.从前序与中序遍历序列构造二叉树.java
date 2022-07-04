import java.util.HashMap;
import java.util.Map;

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
    int preIdx;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preorder[preIdx];
        TreeNode root = new TreeNode(val);
        Integer idx = inMap.get(val);

        preIdx++;
        root.left = helper(left, idx - 1);
        root.right = helper(idx + 1, right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preIdx = 0;
        this.preorder = preorder;
        this.inorder = inorder;

        int i = 0;
        for (int num : inorder) {
            inMap.put(num, i++);
        }

        return helper(0, i - 1);
    }
}