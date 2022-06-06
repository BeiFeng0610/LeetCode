class ListNode {
    int val;
    ListNode next;
    ListNode perv;
    ListNode(int val) { this.val = val; }
}
class MyLinkedList {
    int size;
    ListNode head;
    ListNode tail;

    public MyLinkedList() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        size = 0;
        head.next = tail;
        tail.perv = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;

        if (index + 1 < size - index) {
            for (int i = 0; i < index + 1; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = 0; i < size - index; i++) {
                curr = curr.perv;
            }
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index <= 0) {
            index = 0;
        }

        ListNode prev, next;
        if (index < size - index) {
            prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            next = prev.next;
        } else {
            next = tail;
            for (int i = 0; i < size - index; i++) {
                next = next.perv;
            }
            prev = next.perv;
        }

        ++size;
        ListNode node = new ListNode(val);
        node.next = next;
        node.perv = prev;
        prev.next = node;
        next.perv = node;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode prev, next;
        if (index < size - index) {
            prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            next = prev.next.next;
        } else {
            next = tail;
            for (int i = 0; i < size - index - 1; i++) {
                next = next.perv;
            }
            prev = next.perv.perv;
        }
        --size;
        prev.next = next;
        next.perv = prev;
    }
}
