class Solution {
    Map<String, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    // 利用深度优先遍历，拼接出一个key，存放从当前结点（key为从当前结点拼接的）
    public String dfs(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String serial = node.val + "," + dfs(node.left) + "," + dfs(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) {
            ans.add(node);
        }
        return serial;
    }
}

class Solution2 {
    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap<>();
        count = new HashMap<>();
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        String serial = node.val + "," + dfs(node.left) + "," + dfs(node.right);
        // 把每种字符串  都用数字标记，  如果存在字符串  就获取key
        int uid = trees.computeIfAbsent(serial, x -> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2) {
            ans.add(node);
        }
        return uid;
    }
}
