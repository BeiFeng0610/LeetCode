class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=new ListNode();
        // 增加前置结点，易于操作。还能限制边界。
        temp.next=head;
        // 快慢指针，fast先走n位，然后pre跟着走。slow为pre的下一个结点，为待删除结点。
        ListNode fast=temp;
        ListNode slow=head;
        ListNode pre=temp;
        while(n-- > 0){
            fast=fast.next;
        }
        // fast下一个结点为null，则表示为最后一个结点。则pre距离fast为n为，则待删结点为pre的下一个结点。
        while(fast.next!=null){
            fast=fast.next;
            pre=slow;
            slow=slow.next;
        }
        pre.next=slow.next;
        return temp.next;
    }
}
