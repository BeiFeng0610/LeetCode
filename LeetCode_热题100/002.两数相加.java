class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = num >= 10 ? 1 : 0;
            tmp.next = new ListNode(num % 10);

            tmp = tmp.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head.next;
    }
}