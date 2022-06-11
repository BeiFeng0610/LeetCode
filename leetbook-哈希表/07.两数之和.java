class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] temp = new int[2];

        int left,right;
        for (left = 0; left < len; left++) {
            for (right = left + 1;  right < len; right ++) {
                if (nums[left] + nums[right] == target){
                    temp[0] = left;
                    temp[1] = right;
                    return temp;
                }
            }
        }

        return temp;
    }
}
