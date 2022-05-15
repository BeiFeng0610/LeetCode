class Solution<T> {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len = arr1.length;
        Arrays.sort(arr1);
        int r = len - 1, l = 0;
        int[] res = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr2) {
            map.put(a, 0);
        }
        for (int i = len - 1; i >= 0; i--) {
            int t = arr1[i];
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                res[r--] = t;
            }
        }
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
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }
}
