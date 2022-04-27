class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=new ListNode();
        temp.next=head;
        ListNode fast=temp;
        ListNode slow=head;
        ListNode pre=temp;
        while(n-- > 0){
            fast=fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            pre=slow;
            slow=slow.next;
        }
        pre.next=slow.next;
        return temp.next;
    }
}
