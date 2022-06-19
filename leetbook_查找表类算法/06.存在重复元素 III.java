import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            // 从set中找到大于等于  跟定数  中的最小的数
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            // 如果存在，且满足  后面的：例如 t = 1 num[i] = 2, 如果set中存在[1,3]即满足
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}