import java.util.Deque;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        if (head == null) {
            return head;
        }
        while (head != null) {
            while (!stack.isEmpty() && stack.getFirst().val < head.val) {
                stack.removeFirst();
            }
            stack.addFirst(head);
            head = head.next;
        }
        ListNode res = new ListNode();
        ListNode tmp = res;
        while (!stack.isEmpty()) {
            tmp.next = stack.removeLast();
            tmp = tmp.next;
        }
        tmp.next = null;
        return res.next;
    }
}