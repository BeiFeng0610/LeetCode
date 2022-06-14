class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(-1, head);
        ListNode res = tmp;
        // 不符合就跳过，符合删除
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return res.next;
    }
}
