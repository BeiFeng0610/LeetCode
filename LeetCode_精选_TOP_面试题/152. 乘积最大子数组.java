class Solution {
    public int maxProduct(int[] nums) {
        int tMax = 1, tMin = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = tMax;
                tMax = tMin;
                tMin = tmp;
            }
            tMax = Math.max(tMax * nums[i], nums[i]);
            tMin = Math.min(tMin * nums[i], nums[i]);
            max = Math.max(max, tMax);
        }
        return max;
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int a = 1;
        int max = nums[0];

        for (int num : nums) {
            a = a * num;
            if (max < a) {
                max = a;
            }
            if (num == 0) {
                a = 1;
            }
        }
        a = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            a = a * nums[i];
            if (max < a) {
                max = a;
            }
            if (nums[i] == 0) {
                a = 1;
            }
        }
        return max;
    }
}
