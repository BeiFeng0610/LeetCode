class Solution {
    // 创建新节点，然后遍历旧结点，头插法即可
    public ListNode reverseList(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = root.next;
            root.next = tmp;
        }
        return root.next;
    }
}
