class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode postNode = head;
        ListNode preNode = head;
        for (int i = 0; i < k; i++) {
            postNode = postNode.next;
        }
        while (postNode != null) {
            preNode = preNode.next;
            postNode = postNode.next;
        }
        return preNode.val;
    }
}