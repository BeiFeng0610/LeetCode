package leetbook_哈希表;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> countAB = new HashMap<>();
        // 把两个数组所有数字的组合记录出来
        for (int u : nums1) {
            for (int v : nums2) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        // 在用另外两个数组的数组记录，查询map中是否存在与这两个数组合的  反数
        for (int u : nums3) {
            for (int v : nums4) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }

        return ans;
    }
}