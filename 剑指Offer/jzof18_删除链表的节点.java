package 剑指Offer;

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode tmp = node;
        while (tmp.next.val != val) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return node;
    }
}
