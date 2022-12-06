class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode reverse = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = tmp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (reverse != null) {
            if (reverse.val != slow.val) {
                return false;
            }
            reverse = reverse.next;
            slow = slow.next;
        }
        return true;
    }
}