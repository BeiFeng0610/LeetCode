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
            } else {
                sb.append("null").append(",");
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                sb.append(poll.right.val).append(',');
            } else {
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
        String sub = data.substring(1, data.length() - 1);
        String[] nodes = sub.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;
        while (!queue.isEmpty() && idx < nodes.length) {
            TreeNode node = queue.poll();
            if (!"null".equals(nodes[idx])) {
                TreeNode tmp = new TreeNode(Integer.parseInt(nodes[idx]));
                queue.offer(tmp);
                node.left = tmp;
            }
            idx++;
            if (!"null".equals(nodes[idx])) {
                TreeNode tmp = new TreeNode(Integer.parseInt(nodes[idx]));
                queue.offer(tmp);
                node.right = tmp;
            }
            idx++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));