class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode fast = new ListNode(-1, head);
        ListNode slow = new ListNode(-1, head);

        while (fast != null && n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next == head) {
            return head.next;
        } else {
            slow.next = slow.next.next;
        }
        return head;
    }
}