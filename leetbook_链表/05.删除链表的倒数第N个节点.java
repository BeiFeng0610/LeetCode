class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tou = new ListNode(0,head);
        ListNode left = tou;
        ListNode right = head;
        for(int i = 0; i < n; i++){
            right = right.next;
        }
        while(right != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return tou.next;
    }
}
