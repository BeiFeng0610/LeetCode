class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        // 前缀为0时，下标肯定在-1
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // num == 1 时记录0和1的个数差值
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            // counter-- 后，差值减少，找到差值起始下标，相减，记录最大长度。
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // 更新最大差值下标。
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}
