class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new LinkedList<>();
        Deque<ListNode> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode res = new ListNode(-1);
        int jin = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || jin != 0) {
            // 两个栈，不为空则弹出，相加记录进位。然后创建新的链表。
            ListNode node = new ListNode();
            int n1 = stack1.peek() == null ? 0 : stack1.pop().val;
            int n2 = stack2.peek() == null ? 0 : stack2.pop().val;
            int num = n1 + n2 + jin;
            if (num < 10) {
                node.val = num;
            } else {
                node.val = num - 10;
            }
            node.next = res.next;
            res.next = node;
            jin = num >= 10 ? 1 : 0;
        }
        return res.next;
    }
}
