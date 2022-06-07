class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head, right = head.next;
        int count = 1;
        while (right.next != null) {
            // 只需要把奇数位结点  断开连接  重新加到left后面即可
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
