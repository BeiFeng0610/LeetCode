class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (mid < r && arr[mid] > arr[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
