import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    LinkNode head;
    Map<Integer, LinkNode> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        head = new LinkNode(-1, -1);
        head.next = head;
        head.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        //1.拿到node
        LinkNode node = map.get(key);
        //2.等于null返回-1
        if (node == null) {
            return -1;
        }
        //3.不等于null，更新链表，把结点放到链表头
        //3.1从当前断开，放到链表头
        oldPush(node);
        return node.val;
    }

    public void put(int key, int value) {
        //1.查询是否存在
        LinkNode node = map.get(key);
        //2.存在就更新值，放到表头
        if (node != null) {
            node.val = value;
            oldPush(node);
            return;
        }
        //3.超过容量删除表尾元素
        if (map.size() == capacity) {
            LinkNode tail = head.pre;
            removeNode(tail);
            map.remove(tail.key);
        }
        //4.新建结点放到表头
        LinkNode newNode = new LinkNode(key, value);
        map.put(key, newNode);
        newPush(newNode);
    }

    private void newPush(LinkNode newNode) {
        newNode.next = head.next;
        newNode.pre = head;
        head.next.pre = newNode;
        head.next = newNode;
    }

    private void removeNode(LinkNode tail) {
        tail.pre.next = tail.next;
        tail.next.pre = tail.pre;
        tail.pre = null;
        tail.next = null;
    }

    private void oldPush(LinkNode node) {
        removeNode(node);
        newPush(node);
    }

    private static class LinkNode{
        int key;
        int val;
        LinkNode next;
        LinkNode pre;

        public LinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}


class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        // accessOrder：是否根据访问顺序，默认为插入顺序
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

