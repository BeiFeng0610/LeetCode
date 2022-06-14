class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 把每个结点，都进行dfs遍历，如果路径和满足就累加，先把root结点进行dfs遍历
        int ret = rootSum(root, targetSum);
        // 然后依次对左右各个结点进行dfs遍历
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        // 满足就累加
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        // 然后继续深入左右结点，会把满足的情况带出来。
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}

class Solution2 {
    public int pathSum(TreeNode root, int targetSum) {
        // 用哈希表记录前缀和
        HashMap<Long, Integer> prefix = new HashMap<>();
        // 初始化前缀和，前缀为0，表示有一种情况满足。
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 获取当前值。
        int ret = 0;
        curr += root.val;
        // 用当前值减去target 去哈希表查找是否有对应前缀，且有几种可能
        ret = prefix.getOrDefault(curr - targetSum, 0);
        // 把当前值加入哈希表，如果有和当前值相同的情况，则value+1
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        // dfs遍历，会把每个结点的ret值带回来。
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        // 当前结点回溯的时候需要删除对应的前缀和。
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}

