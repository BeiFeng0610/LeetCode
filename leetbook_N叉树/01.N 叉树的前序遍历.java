import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
};

class Solution {
    List<Integer> list;
    public List<Integer> preorder(Node root) {
        this.list = new ArrayList<>();
        dfs(root);
        return list;

    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        List<Node> children = node.children;
        for (Node ch : children) {
            dfs(ch);
        }
    }
}

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            /**
             * 从右往左把子节点压入栈中，
             * 会在新一轮中，取出最左子节点
             * 然后会把子节点中得子节点放入栈中，
             * 然后循环重复。
             */
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }

        return res;
    }
}