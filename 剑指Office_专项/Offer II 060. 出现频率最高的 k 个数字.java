class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        // 统计每个数字出现的次数
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // 优先队列，存放元素为数组，把key和value封装为数组传入，然后按照value大小排序
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            // 队列数量 == k 时，看队头的value是否小于 待加入的value
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
                // 队列没满，就直接加入
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        // 遍历到key，存入集合即可
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll()[0];
        }

        return ret;
    }
}
