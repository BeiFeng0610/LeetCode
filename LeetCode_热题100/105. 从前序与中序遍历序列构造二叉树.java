import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
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
    Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preIdx = 0;
        this.preorder = preorder;

        int idx = 0;
        for (int num : inorder) {
            inMap.put(num, idx++);
        }

        return helper(0, idx - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preorder[preIdx];
        TreeNode root = new TreeNode(val);
        int idx = inMap.get(val);

        preIdx++;
        root.left = helper(left, idx - 1);
        root.right = helper(idx + 1, right);
        return root;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;

        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                // 栈中的节点的顺序和它们在前序遍历中出现的顺序是一致的，
                // 而且每一个节点的右儿子都还没有被遍历过，
                // 那么这些节点的顺序和它们在中序遍历中出现的顺序一定是相反的。
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}

