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
        if (head == null) {
            return null;
        }
        Map<Node, Integer> nodeMap = new HashMap<>();
        List<Node> nodeList = new ArrayList<>();
        Node tmp = head;
        int idx = 0;
        while (tmp != null) {
            Node node = new Node(tmp.val);
            nodeMap.put(tmp, idx++);
            nodeList.add(node);
            tmp = tmp.next;
        }

        for (int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).random = head.random == null ? null : nodeList.get(nodeMap.get(head.random));
            if (i != 0) {
                nodeList.get(i - 1).next = nodeList.get(i);
            }
            head = head.next;
        }
        return nodeList.get(0);
    }
}

class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node tmp = head;
        // 用map保存新的结点。
        while (tmp != null) {
            nodeMap.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }
        tmp = head;
        // 根据原来链表，把所有结点全部连一起
        while (tmp != null) {
            nodeMap.get(tmp).next = nodeMap.get(tmp.next);
            nodeMap.get(tmp).random = nodeMap.get(tmp.random);
            tmp = tmp.next;
        }
        return nodeMap.get(head);
    }
}

class Solution3 {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
