class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 遍历的结点数量一定相同，全部遍历完  两边会同时为null
        ListNode hA = headA, hB = headB;
        while (hA != hB) {
            hA = hA == null ? headB : hA.next;
            hB = hB == null ? headA : hB.next;
        }
        return hA;
    }
}
