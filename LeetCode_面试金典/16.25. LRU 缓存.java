import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Node> map;
    Node head;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        cap = capacity;
        Node node = new Node(-1);
        head = node;
        node.next = node;
        node.pre = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 获取节点放到队头
            Node node = map.get(key);
            newHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 覆盖新值放到队头
            Node node = map.get(key);
            node.val = value;
            newHead(node);
            return;
        }
        // 如果容量已满，则删除队尾元素
        if (map.size() == cap) {
            map.remove(head.pre.key);
            delNode(head.pre);
        }
        // 插入新节点到队头
        Node node = new Node(key, value);
        map.put(key, node);
        inNode(node);
    }

    // 把节点放到队头
    private void newHead(Node node) {
        delNode(node);
        inNode(node);
    }

    private void delNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void inNode(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    static class Node {
        Node next;
        Node pre;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}