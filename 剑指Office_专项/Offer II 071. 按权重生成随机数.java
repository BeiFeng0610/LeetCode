class Solution {
    int[] pre;
    int total;
    public Solution(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        total = w[0];
        // 创建新数组，统计前缀和，也就是下标触发的权值区间
        for (int i = 1; i < w.length; i++) {
            pre[i] = pre[i - 1] + w[i];
            // 统计权值
            total += w[i];
        }
    }

    public int pickIndex() {
        // 权值从1开始，需要随机数+1
        int idx = (int) (Math.random() * total) + 1;
        // 找到权值所在的区间，也就是数组可插入的区间(]
        return binarySearch(idx);
    }
    private int binarySearch(int x) {
        int l = 0, r = pre.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (pre[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            } 
        }
        return l;
    }
}
