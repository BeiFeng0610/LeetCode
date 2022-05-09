class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        // 为了防止溢出，用long类型存储
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            // treeset的ceiling 是返回大于或等于给定值的最小值没有则null。 num[i] - num[j] <= t ==> num[j] >= num[i] - t; 
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            // 如果不为null，判断是否符合条件 
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            // 保持窗口宽度
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}


class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<Long, Long>();
        // 桶排序，差值，一个桶内的肯定满足，邻桶可能满足
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            //获取桶号
            long id = getID(nums[i], w);
            // 存在直接返回 不存在判断邻桶
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            // 保持窗口宽度
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    public long getID(long x, long w) {
        //自然数桶编号，负数因为不包含0号桶也不包含0，所以x+1  桶序号-1
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }
}
