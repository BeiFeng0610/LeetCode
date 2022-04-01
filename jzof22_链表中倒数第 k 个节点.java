/*
*   双指针：
*       两指针前后间隔k
* */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
    }
}
