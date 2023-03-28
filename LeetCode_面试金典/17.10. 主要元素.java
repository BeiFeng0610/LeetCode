class Solution {
    public int majorityElement(int[] nums) {
        int res = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count++;
            } else {
                count += res == num ? 1 : -1;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == res) {
                count++;
            }
        }
        return count > nums.length / 2 ? res : -1;
    }
}