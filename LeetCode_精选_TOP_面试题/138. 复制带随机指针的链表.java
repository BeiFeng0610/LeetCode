import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        if (head == null) {
            return null;
        }
        map.put(null, null);
        Node tmp = head;
        while (tmp != null) {
            Node newNode = new Node(tmp.val);
            map.put(tmp, newNode);
            tmp = tmp.next;
        }
        Node res = new Node(-1);
        Node cur = res;
        tmp = head;
        while (tmp != null) {
            cur.next = map.get(tmp);
            cur.random = map.get(tmp.random);
            cur = cur.next;
            tmp = tmp.next;
        }

        return res.next;
    }
}

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        map.put(null, null);
        return helper(head);
    }

    public Node helper(Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        newNode.next = helper(node.next);
        newNode.random = map.get(node.random);
        return newNode;
    }
}

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node node = new Node(head.val);
            map.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}