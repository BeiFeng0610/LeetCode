class Solution {
    public int singleNumber(int[] nums) {
        int[] res = new int[32];
        // 统计每个位数的出现次数。
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                res[i] += num & 1;
                num >>= 1;
            }
        }
        // 如果余数不为0，则提取相应位数
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (res[i] % 3 != 0) {
                ans += 1 << i;
            }
        }
        return ans;
    }
}
