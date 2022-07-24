class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tmp = head;
        int jin = 0;
        while (l1 != null || l2 != null) {
            int num1 = 0, num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int num = num1 + num2 + jin;
            jin = num >= 10 ? 1 : 0;
            tmp.next = new ListNode(num % 10);
            tmp = tmp.next;
        }
        tmp.next = jin == 1 ? new ListNode(1) : null;
        return head.next;
    }
}