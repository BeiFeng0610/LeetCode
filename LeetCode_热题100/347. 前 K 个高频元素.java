import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        map.forEach((key, value) -> {
            if (queue.size() == k) {
                if (queue.peek()[1] < value) {
                    queue.poll();
                    queue.offer(new int[]{key, value});
                }
            } else {
                queue.offer(new int[]{key, value});
            }
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}