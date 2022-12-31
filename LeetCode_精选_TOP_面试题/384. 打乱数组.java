import java.util.Arrays;
import java.util.Random;

class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int len = nums.length;
        int[] ans = Arrays.copyOf(nums, len);
        for (int i = 0; i < len; i++) {
            swap(ans, i, i + random.nextInt(len - i));
        }
        return ans;
    }

    private void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */