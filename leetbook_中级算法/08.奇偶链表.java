class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ouHead = head.next;
        ListNode jiTail = head, ouTail = ouHead;

        while (ouTail != null && ouTail.next != null) {
            jiTail.next = ouTail.next;
            jiTail = jiTail.next;
            ouTail.next = jiTail.next;
            ouTail = ouTail.next;
        }
        jiTail.next = ouHead;
        return head;
    }
}