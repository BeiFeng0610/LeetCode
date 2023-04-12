class Solution {
    // 用list记录dfs遍历的顺序，然后依次连接即可。
    List<Node> list = new ArrayList<>();

    public Node flatten(Node head) {
        DFS(head);
        Node res = head;
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
            list.get(i).prev = list.get(i - 1);
            list.get(i - 1).child = null;
            list.get(i).child = null;
        }
        return res;
    }

    private void DFS(Node node){
        if (node == null) {
            return;
        }
        while (node != null) {
            list.add(node);
            if (node.child != null) {
                DFS(node.child);
            }
            node = node.next;
        }
    }
}


class Solution2 {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {
        Node cur = node;
        // 记录链表的最后一个节点
        Node last = null;

        while (cur != null) {
            Node next = cur.next;
            // 如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node childLast = dfs(cur.child);

                next = cur.next;
                //  将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;

                //  如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                // 将 child 置为空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
