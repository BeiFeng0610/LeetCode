class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode tou = new ListNode(0,head);
        ListNode t = new ListNode(0);
        ListNode m = new ListNode();
        while(tou.next!=null){
            m = tou.next;
            tou.next = m.next;
            m.next = t.next;
            t.next=m;
            
        }
        return t.next;
    }
}
