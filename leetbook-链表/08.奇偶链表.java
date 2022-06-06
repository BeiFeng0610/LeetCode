class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head, right = head.next;
        int count = 1;
        while (right.next != null) {
            if (count % 2 != 0) {
                ListNode tmp = right.next;
                right.next = tmp.next;
                tmp.next = left.next;
                left.next = tmp;
                left = tmp;
            } else {
                right = right.next;
            }
            count++;
        }

        return head;
    }
}
