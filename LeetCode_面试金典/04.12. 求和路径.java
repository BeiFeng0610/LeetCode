import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private int count = 0;
    private List<Integer> list = new ArrayList<>();

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum);
        return count;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        int sum = node.val;
        if (sum == target) {
            count++;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i);
            if (sum == target) {
                count++;
            }
        }
        list.add(node.val);
        dfs(node.left, target);
        dfs(node.right, target);
        list.remove(list.size() - 1);
    }
}


class Solution {
    private Map<Integer, Integer> prefix = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        prefix.put(0, 1);
        return dfs(root, 0, sum);
    }

    private int dfs(TreeNode node, int cur, int target) {
        if (node == null) {
            return 0;
        }
        int cnt = 0;
        cur += node.val;
        cnt += prefix.getOrDefault(cur - target, 0);
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        cnt += dfs(node.left, cur, target);
        cnt += dfs(node.right, cur, target);
        prefix.put(cur, prefix.getOrDefault(cur, 0) - 1);
        return cnt;
    }
}