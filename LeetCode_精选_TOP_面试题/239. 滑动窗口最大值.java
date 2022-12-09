import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (i < k) {
                while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                    queue.removeLast();
                }
                queue.addLast(nums[i]);
            } else {
                if (nums[i - k] == queue.getFirst()) {
                    queue.removeFirst();
                }
                while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                    queue.removeLast();
                }
                queue.addLast(nums[i]);
            }
            if (i >= k - 1) {
                res[i - k + 1] = queue.getFirst();
            }
        }
        return res;
    }
}