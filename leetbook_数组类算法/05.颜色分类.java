class Solution {
    public void sortColors(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            }else if(nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            }else {
                nums[num2++] = 2;
            }
        }
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }
}

