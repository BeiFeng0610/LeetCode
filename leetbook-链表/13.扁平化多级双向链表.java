class Solution {
    List<Node> nodes;
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        nodes = new ArrayList<>();
        dfs(head);
        // 根据集合中的结点，按照顺序依次连接，把子节点清空。
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

    // 深度优先遍历，把所有的结点全部按顺序放到集合中。
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
