class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
};

class Solution {
    Node last = null, nextStart = null;
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // 开始结点
        Node start = root;
        while (start != null) {
            // 初始化下层，最后一个结点，和下一层开始结点
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            // 更新为下一个开始结点
            start = nextStart;
        }
        return root;
    }


    public void handle(Node p) {
        // 如果有最后一个结点，更新结点的next
        if (last != null) {
            last.next = p;
        }
        // 如果还没找到下一层开始结点，则把第一个传入的结点记为下一层开始的结点。
        if (nextStart == null) {
            nextStart = p;
        }
        // 更新下层的最后一个结点
        last = p;
    }
}