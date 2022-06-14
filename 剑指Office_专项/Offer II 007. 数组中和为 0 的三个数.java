class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 与前一位相同，直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 第一位必为负值，才能有效
            int target = -nums[i];
            // 设定第三个值的边界
            int k = len - 1;
            for (int j = i + 1; j < len; j++) {
                // 与前一位相同，直接跳过
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 右边界左移
                while (j < k && nums[j] + nums[k] > target) {
                    --k;
                }
                // 第二三数重合，说明没有符合条件的。
                if (k == j) {
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}
