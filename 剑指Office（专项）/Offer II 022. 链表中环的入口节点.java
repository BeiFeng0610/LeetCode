class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
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


class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        Set<ListNode> set = new HashSet<>();
        while (tmp != null) {
            ListNode t = tmp;
            if (!set.contains(t)) {
                set.add(t);
            } else {
                return t;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
