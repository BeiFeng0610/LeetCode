class Solution {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int l = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 != 0) {
                int tmp = nums[l];
                nums[l++] = nums[i];
                nums[i] = tmp;
            }
        }
        return nums;
    }
}

class Solution {
    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            // 找到最左边的偶数和最右边的奇数交换
            while(l < r && nums[l] % 2 == 1){
                l++;
            }
            while(l < r && nums[r] % 2 == 0){
                r--;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        return nums;
    }
}