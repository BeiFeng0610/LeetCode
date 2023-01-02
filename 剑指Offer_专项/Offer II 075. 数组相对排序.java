class Solution<T> {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len = arr1.length;
        // 排序
        Arrays.sort(arr1);
        int r = len - 1, l = 0;
        int[] res = new int[len];
        // 初始化哈希表
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr2) {
            map.put(a, 0);
        }
        // 更新哈希表数字个数
        for (int i = len - 1; i >= 0; i--) {
            int t = arr1[i];
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                res[r--] = t;
            }
        }
        // 更新新数组
        for (int a : arr2) {
            for (int i = 0; i < map.get(a); i++) {
                res[l++] = a;
            }
        }

        return res;
    }
}

class Solution2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 取值在 0-1000，可用计数排序
        int upper = 0;
        for (int x : arr1) {
            // 取最大数字
            upper = Math.max(upper, x);
        }
        // 创建一个最大数字的数字
        int[] frequency = new int[upper + 1];
        // 根据数字更新每个数的个数
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        // 先添加arr2中的数字，根据个数添加，然后清0
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        // 根据计数更新每个数字的个数和前后顺序
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }
}
