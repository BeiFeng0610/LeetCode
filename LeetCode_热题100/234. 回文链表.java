class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode tailHead = tailHead(head);
        ListNode reverse = reverse(tailHead.next);

        while (reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    private ListNode tailHead(ListNode node) {
        ListNode fast = node, slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode res = new ListNode();

        while (node != null) {
            ListNode tmp = node;
            node = node.next;
            tmp.next = res.next;
            res.next = tmp;
        }

        return res.next;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode reverse = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            ListNode tmp = slow.next;
            fast = fast.next.next;
            slow.next = reverse;
            reverse = slow;
            slow = tmp;
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
