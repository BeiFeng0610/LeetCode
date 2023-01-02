package 剑指Offer;

class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root,int target) {
        dfs(new ArrayList<>(), root, 0, target, 0);
        return lists;
    }

    public void dfs(List<Integer> list, TreeNode node,int nums, int target, int count) {
        if (node == null) {
            return;
        }

        nums += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null && nums == target) {
            List<Integer> tmp = new ArrayList<>(list);
            lists.add(tmp);
        }
        dfs(list, node.left, nums, target, count + 1);
        dfs(list, node.right, nums, target, count + 1);
        list.remove(count);
    }
}
