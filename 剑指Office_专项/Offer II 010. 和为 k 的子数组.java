class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0, pre = 0;
        // 初始化
        map.put(0, 1);
        for (int n : nums) {
            // 记录前缀和
            pre += n;
            // 判断是否有pre-k的前缀，统计出现次数，累加。
            if (map.containsKey(pre - k)) {
                cnt += map.get(pre - k);
            }
            // 此前缀和记录加1
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cnt;
    }
}
