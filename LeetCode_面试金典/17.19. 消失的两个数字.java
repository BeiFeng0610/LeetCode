class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int cur = n * (n + 1) / 2;
        for (int num : nums) {
            cur -= num;
        }
        int sum = cur, t = cur / 2;
        cur = t * (t + 1) / 2;
        for (int num : nums) {
            if (num <= t) {
                cur -= num;
            }
        }
        return new int[]{cur, sum - cur};
    }
}

class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2, cur = 0;
        for (int i = 1; i <= n; i++) {
            cur ^= i;
        }
        for (int x : nums) {
            cur ^= x;
        }
        int t = cur, d = -cur & cur;
        cur = 0;
        for (int i = 1; i <= n; i++) {
            if ((d & i) != 0) {
                cur ^= i;
            }
        }
        for (int x : nums) {
            if ((d & x) != 0) {
                cur ^= x;
            }
        }
        return new int[]{cur, t ^ cur};
    }
}
