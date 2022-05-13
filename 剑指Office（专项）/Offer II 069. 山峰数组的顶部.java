class Solution {
    // 可以暴力直接遍历到最大值即可，这是二分
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            // 中心点，一般都是偏左，直接判断中点是否大于右边的一个点
            if (mid < r && arr[mid] > arr[mid + 1]) {
                // 大于就是右边界等于中点，范围变成l mid
                r = mid;
            } else {
                // 不存在等于，小于，范围变成 mid + 1 -- r 
                l = mid + 1;
            }
        }
        return l;
    }
}
