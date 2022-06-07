class Solution {
    List<Node> nodes;
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        nodes = new ArrayList<>();
        dfs(head);
        for (int i = 0; i < nodes.size() - 1; i++) {
            Node prev = nodes.get(i);
            Node tail = nodes.get(i + 1);
            prev.child = null;
            prev.next = tail;
            tail.prev = prev;
            tail.child = null;
        }
        return head;
    }

    public void dfs(Node node){
        if (node == null) {
            return;
        }
        nodes.add(node);
        if (node.child != null) {
            dfs(node.child);
        }

        dfs(node.next);

    }
}
