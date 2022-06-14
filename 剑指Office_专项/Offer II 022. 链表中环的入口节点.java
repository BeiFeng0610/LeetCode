class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        // 快慢指针，慢走1，快走2，如果有环，快慢碰见的距离：假设慢走x，快就走2x
        // 设开始结点到入口结点为y，则慢指针再走y步也能到入口，因为慢结点要走x才能到现在的位置，初始结点到现在的位置也是x步，减去重合部分，所以初始结点y步和慢指针y步刚好重合
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

// 哈希表
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
