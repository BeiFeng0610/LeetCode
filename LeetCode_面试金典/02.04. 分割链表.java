import java.util.LinkedList;
import java.util.Queue;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode partition(ListNode head, int x) {
        Queue<ListNode> lt = new LinkedList<>();
        Queue<ListNode> ge = new LinkedList<>();
        while (head != null) {
            if (head.val < x) {
                lt.offer(head);
            } else {
                ge.offer(head);
            }
            head = head.next;
        }
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        for (ListNode node : lt) {
            tmp.next = node;
            tmp = tmp.next;
        }
        for (ListNode node : ge) {
            tmp.next = node;
            tmp = tmp.next;
        }
        tmp.next = null;
        return res.next;
    }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode tmp = pre;
        if (tmp.next.val < x) {
            tmp = tmp.next;
        }
        while (tmp.next != null) {
            if (tmp.next.val < x) {
                ListNode node = tmp.next;
                tmp.next = tmp.next.next;
                node.next = pre.next;
                pre.next = node;
            }
            if (tmp.next != null && tmp.next.val >= x) {
                tmp = tmp.next;
            }
        }
        return pre.next;
    }
}
















