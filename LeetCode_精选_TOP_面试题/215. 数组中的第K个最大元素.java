import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int num : nums) {
            if (queue.size() == k) {
                if (queue.peek() < num) {
                    queue.remove();
                    queue.offer(num);
                }
            } else {
                queue.offer(num);
            }
        }
        return queue.peek();
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // hash
        // 对于求第k大元素 我们可以利用hash的单调性来进行排序 统计值域范围后 将其映射到hash表上 倒叙循环统计第k大即可
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int[] hash = new int[max - min + 1];
        for (int num : nums) {
            hash[num - min]++;
        }
        for (int i = max - min; i >= 0; i--) {
            k -= hash[i];
            if (k <= 0) {
                return i + min;
            }
        }
        return -1;
    }
}