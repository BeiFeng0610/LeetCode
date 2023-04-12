package 剑指Offer第2版;

class Solution {
    public int[] reversePrint(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop().val;
        }
        return res;
    }
}
