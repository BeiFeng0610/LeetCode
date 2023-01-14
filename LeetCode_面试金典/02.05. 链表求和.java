class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = (l1 != null ? l1.val : 0);
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum > 9 ? 1 : 0;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return res.next;
    }
}