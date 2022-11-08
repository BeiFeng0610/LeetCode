import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        root.next = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.left != null) {
                    poll.left.next = poll.right;
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    poll.right.next = poll.next == null ? null : poll.next.left;
                    queue.offer(poll.right);
                }
            }
        }
        return root;
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node nextHead = root;
        while (nextHead.left != null) {
            Node head = nextHead;
            nextHead = nextHead.left;
            while (head != null) {
                head.left.next = head.right;
                head.right.next = head.next == null ? null : head.next.left;
                head = head.next;
            }
        }
        return root;
    }
}