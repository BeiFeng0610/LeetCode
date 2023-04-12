package 剑指Offer第2版;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode wei = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                wei.next = l1;
                l1 = l1.next;
            } else {
                wei.next = l2;
                l2 = l2.next;
            }
            wei = wei.next;
        }
        wei.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
