class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        while (head != null && head != stack.peek()) {
            ListNode node = stack.pop();
            stack.peek().next = null;
            node.next = head.next;
            head.next = node;
            head = head.next.next;
        }
    }
}

class Solution2 {
    public void reorderList(ListNode head) {
        ListNode mid = midNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode midNode(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode root) {
        ListNode head = new ListNode(-1);
        ListNode tmp = null;
        while (root != null) {
            tmp = root;
            root = root.next;
            tmp.next = head.next;
            head.next = tmp;
        }
        return head.next;
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1Tmp;
        ListNode l2Tmp;

        while (l1 != null && l2 != null) {
            l1Tmp = l1.next;
            l2Tmp = l2.next;

            l1.next = l2;
            l1 = l1Tmp;

            l2.next = l1;
            l2 = l2Tmp;
        }
    }
}
