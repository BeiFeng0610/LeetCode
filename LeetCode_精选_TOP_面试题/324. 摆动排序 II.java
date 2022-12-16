import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int len = nums.length;
        int x = (len + 1) / 2;
        for (int i = 0, j = x - 1, k = len - 1; i < len; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < len) {
                nums[i + 1] = arr[k];
            }
        }
    }
}