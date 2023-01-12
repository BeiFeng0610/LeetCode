import java.util.HashSet;
import java.util.Set;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode res = new ListNode(-1), tmp = res;
        while (head != null) {
            if (!set.contains(head.val)) {
                set.add(head.val);
                tmp.next = head;
                tmp = tmp.next;
            }
            head = head.next;
        }
        tmp.next = null;
        return res.next;
    }
}

class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode res = head;
        while (head.next != null) {
            if (set.add(head.next.val)) {
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        }
        return res;
    }
}