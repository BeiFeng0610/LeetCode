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
        ListNode one = head;
        ListNode two = head.next;

        while (two != null && two.next != null) {
            ListNode tmp = two.next;
            two.next = tmp.next;
            tmp.next = one.next;
            one.next = tmp;
            one = one.next;
            two = two.next;
        }
        return head;
    }
}