import java.util.*;

class LRUCache {
    private LinkNode head;
    private Map<Integer, LinkNode> map = new HashMap<>();
    private int len;

    public LRUCache(int capacity) {
        head = new LinkNode(-1,-1);
        head.next = head;
        head.pre = head;
        len = capacity;
    }

    public int get(int key) {
        LinkNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 访问数据放到表头，返回数据
        oldPush(node);
        return node.val;
    }

    public void put(int key, int value) {
        LinkNode node = map.get(key);
        // 存在更新值，放到表头
        if (node != null) {
            node.val = value;
            oldPush(node);
        } else {
            // 超过长度，淘汰一个
            if (map.size() == len) {
                LinkNode preNode = head.pre;
                removeNode(preNode);
                map.remove(preNode.key);
            }
            // 存入新节点，放到表头
            LinkNode newNode = new LinkNode(key, value);
            map.put(key, newNode);
            newPush(newNode);
        }
    }

    private void removeNode(LinkNode node) {
        LinkNode pre = node.pre;
        LinkNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void newPush(LinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void oldPush(LinkNode node) {
        removeNode(node);
        newPush(node);
    }
}

class LinkNode {
    int key;
    int val;
    LinkNode pre;
    LinkNode next;

    public LinkNode() {

    }

    public LinkNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public LinkNode(int key, int val, LinkNode pre, LinkNode next) {
        this.key = key;
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkNode linkNode = (LinkNode) o;
        return key == linkNode.key && val == linkNode.val && Objects.equals(pre, linkNode.pre) && Objects.equals(next, linkNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, val, pre, next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */