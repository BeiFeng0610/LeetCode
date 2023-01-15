class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head, reverse = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow;
            slow = slow.next;
            tmp.next = reverse;
            reverse = tmp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != reverse.val) {
                return false;
            }
            slow = slow.next;
            reverse = reverse.next;
        }
        return true;
    }
}