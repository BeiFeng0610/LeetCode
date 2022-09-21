class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode();
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = res.next;
            res.next = tmp;
        }

        return res.next;
    }
}