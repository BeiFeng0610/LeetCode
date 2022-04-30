class Solution {
    public Node insert(Node head, int insertVal) {
        Node cur = null;
        Node next = null;
        Node realHead = null;
        // 空结点处理
        if(head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        //找到真正的头节点，cur为尾结点。next为头节点
        cur = head;
        next = head.next;
        while(cur.val <= next.val){
            cur = cur.next;
            next = next.next;
            if(cur == head) break;
        }
        realHead = next;

        //找插入位置
        while(next.val < insertVal){
            cur = next;
            next = next.next;
            //相等了，就随便插
            if(next == realHead)break;
        }
        //连接
        cur.next = new Node(insertVal);
        cur = cur.next;
        cur.next = next;
        return head;
    }
}
