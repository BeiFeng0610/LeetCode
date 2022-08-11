import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(root.val).append(",");
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
                sb.append(poll.left.val).append(",");
            }else {
                sb.append("null").append(",");
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                sb.append(poll.right.val).append(",");
            }else{
                sb.append("null").append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String substring = data.substring(1, data.length() - 1);
        String[] nodes = substring.split(",");
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty() && idx < nodes.length) {
            TreeNode poll = queue.poll();
            if (!"null".equals(nodes[idx])) {
                poll.left = new TreeNode(Integer.parseInt(nodes[idx]));
                queue.offer(poll.left);
            }
            idx++;
            if (!"null".equals(nodes[idx])) {
                poll.right = new TreeNode(Integer.parseInt(nodes[idx]));
                queue.offer(poll.right);
            }
            idx++;
        }
        return root;
    }
}