class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        // 快慢指针相遇后，快指针走了慢的两倍路程，则慢指针到环开始出走了n步
        // 快指针在环里走了不管多少圈 但是就是碰到了 慢指针
        // 假设环形一圈刚好是慢指针走的路径长度，减去公共部分，慢指针继续走，
        // 在开头重新开始走一个ptr指针，它们两个一定会在环口相遇。
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
