import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        ListNode node = new ListNode(-1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode tmp = node;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                tmp.next = new ListNode(poll.val);
                tmp = tmp.next;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            list.add(node.next);
            node.next = null;
        }
        return list.toArray(new ListNode[0]);
    }
}