import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            // 在集合中找到 >=  某个数的最小值，也就能找到下界
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            // 然后，选出的出比较上界。
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            // 长度超过就开始弹出第一个元素
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}