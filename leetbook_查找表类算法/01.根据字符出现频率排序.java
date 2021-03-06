import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> keyCount = new HashMap<>();
        for (Character c : chars) {
            keyCount.put(c, keyCount.getOrDefault(c, 0) + 1);
        }
        // 把字符按照出现顺序的降序放入优先队列
        PriorityQueue<int []> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        // char  可以转换为 int
        for (Map.Entry<Character, Integer> entry : keyCount.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        // 然后挨个遍历拼接即可
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            char c = (char) poll[0];
            int n = poll[1];
            for (int i = 0; i < n; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}