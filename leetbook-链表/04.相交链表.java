class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode hA = headA, hB = headB;
        while (hA != hB) {
            hA = hA == null ? headB : hA.next;
            hB = hB == null ? headA : hB.next;
        }
        return hA;
    }
}
