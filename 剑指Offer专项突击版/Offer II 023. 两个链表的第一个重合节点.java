class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 两个链表，pa走a+b步 和pb走a+b步，如果有重合结点，一定会重合一次，如果不重合，和出现都变为null，刚好可以返回null
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}
