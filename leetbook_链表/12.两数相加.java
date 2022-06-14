class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode tail = ret;
        int jin = 0;
        // 记录进位，把进位加上
        while (l1 != null || l2 != null) {
            ListNode node = new ListNode();

            int tmp = 0;
            if (l1 == null) {
                tmp = l2.val + jin;
                l2 = l2.next;
            } else if (l2 == null) {
                tmp = l1.val + jin;
                l1 = l1.next;
            } else {
                tmp = l1.val + l2.val + jin;
                l1 = l1.next;
                l2 = l2.next;
            }

            int val = tmp >= 10 ? tmp - 10 : tmp;
            jin = tmp >= 10 ? 1 : 0;
            node.val = val;

            tail.next = node;
            tail = node;


        }
        // 计算完进位如果不为零，最后加一位。
        if (jin != 0) {
            tail.next = new ListNode(1);
        }

        return ret.next;
    }
}
