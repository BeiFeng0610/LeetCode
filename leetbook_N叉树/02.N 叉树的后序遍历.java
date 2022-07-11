import java.util.*;

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
    List<Integer> res;

    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    public void helper(Node node) {
        if (node == null) {
            return;
        }
        for (Node n : node.children) {
            helper(n);
        }
        res.add(node.val);
    }
}

class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            // 如果没有子节点，就可以出栈，或者是被顺着从上倒下压栈进来的，也可以出栈。
            if (node.children.size() == 0 || visited.contains(node)) {
                stack.pop();
                res.add(node.val);
                continue;
            }
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
            visited.add(node);
        }
        return res;
    }

}















