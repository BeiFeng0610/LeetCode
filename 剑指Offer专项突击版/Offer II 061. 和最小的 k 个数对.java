class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 暴力法
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1]) - (o2[0] + o2[1]);
            }
        });
        // 取边界，和最大组合
        int len1 = Math.min(nums1.length, k);
        int len2 = Math.min(nums2.length, k);
        int r = Math.min(len1 * len2, k);
        // 暴力枚举
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                queue.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            int[] poll = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(poll[0]);
            tmp.add(poll[1]);
            res.add(tmp);
        }

        return res;
    }
}

class Solution2 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
            // 根据下标组合排序
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        // 初始化第一个下标
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i,0});
        }
        // 堆顶不空，最多循环k次。
        while (k-- > 0 && !pq.isEmpty()) {
            // 获取堆顶
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            // 判断第二下标边。
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ans;
    }
}
