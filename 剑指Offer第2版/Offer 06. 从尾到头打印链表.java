import java.util.Deque;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// 递归
class Solution {
    int len = 0;
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[len];
        }
        len++;
        int[] arr = reversePrint(head.next);
        arr[len++ - arr.length] = head.val;
        return arr;
    }
}

// 反转链表
class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode root = new ListNode(-1);
        int count = 0;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = root.next;
            root.next = tmp;
            count++;
        }
        int[] res = new int[count];
        int idx = 0;
        root = root.next;
        while (root != null) {
            res[idx++] = root.val;
            root = root.next;
        }
        return res;
    }
}

// 栈
class Solution {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int idx = 0;
        while (!stack.isEmpty()){
            res[idx++] = stack.pop();
        }
        return res;
    }
}