class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

class MyLinkedList {

    private Node head;
    private Node tail;
    private int count;

    public MyLinkedList() {
        this.head = new Node(-1);
        this.tail = head;
        count = 0;
    }

    public int get(int index) {
        if (index >= count) {
            return -1;
        }
        Node tmp = head;
        for (int i = 0; i <= index; i++) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    public void addAtHead(int val) {
        Node tmp = new Node(val);
        if (tail == head) {
            tail = tmp;
        }
        tmp.next = head.next;
        head.next = tmp;
        count++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        count++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        } else if (index == count) {
            addAtTail(val);
        }else if (index > count) {
        } else {
            Node node = new Node(val);
            Node tmp = getNode(index);
            node.next = tmp.next;
            tmp.next = node;
            count++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < count) {
            Node node = getNode(index);
            if (node.next.next == null) {
                tail = node;
            }
            node.next = node.next.next;
            count--;
        }
    }

    private Node getNode(int index) {
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

}
