class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (val == head.val) {
            return head.next;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }
        return head;
    }
}