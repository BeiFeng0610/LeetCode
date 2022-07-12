import java.util.List;

class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public int maxDepth(Node root) {
        return root == null ? 0 : dfs(root) + 1;
    }

    public int dfs(Node node) {
        if (node == null) {
            return 0;
        }
        int max = 0;
        for (Node child : node.children) {
            int dpt = dfs(child);
            max = Math.max(max, dpt);
        }
        return max + 1;
    }
}