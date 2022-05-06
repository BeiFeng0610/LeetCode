class Solution {
    public TreeNode pruneTree(TreeNode root) {
        int nr = dfs(root);
        if (nr == 0) {
            return null;
        }
        return root;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int tmp = node.val;

        if (dfs(node.left) == 0) {
            node.left = null;
        } else {
            tmp += dfs(node.left);
        }
        if (dfs(node.right) == 0) {
            node.right = null;
        } else {
            tmp += dfs(node.right);
        }
        return tmp;
    }
}


class Solution2 {
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }

    public TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        node.left = dfs(node.left);
        node.right = dfs(node.right);
        return node.left==null && node.right==null && node.val==0? null:node;
    }
}
