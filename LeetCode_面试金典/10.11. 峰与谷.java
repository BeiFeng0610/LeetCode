import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return;
        }
        for (int i = 1; i < len; i++) {
            if (i % 2 == 0) {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[j] ^ arr[i];
    }
}