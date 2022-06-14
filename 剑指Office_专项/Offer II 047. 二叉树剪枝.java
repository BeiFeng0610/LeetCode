class Solution {
    public TreeNode pruneTree(TreeNode root) {
        int nr = dfs(root);
        if (nr == 0) {
            return null;
        }
        return root;
    }

    public int dfs(TreeNode node) {
        // 空结点返回 0
        if (node == null) {
            return 0;
        }
        // 记录结点值，以及子节点
        int tmp = node.val;
        
        // 子节点值为0直接置空
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
        // 返回结点总值
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
        
        // 把左节点或者右节点置空
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        // 只有左右结点都为null且结点值为 0 时，才置空
        return node.left==null && node.right==null && node.val==0? null:node;
    }
}
