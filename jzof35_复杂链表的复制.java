class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);
        Node cur = head;
        cNode(cur,map);
        return map.get(head);
    }

    public void cNode(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return;
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        cNode(node.next, map);
        map.get(node).random = map.get(node.random);
        map.get(node).next = map.get(node.next);

    }
}
