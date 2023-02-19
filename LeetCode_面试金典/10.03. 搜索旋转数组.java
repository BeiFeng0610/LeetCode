class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int result = -1;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r + 1) >> 1;
            if (arr[l] == target) {
                return l;
            } else if (arr[l] == arr[mid]) {
                l++;
            } else if (arr[l] < arr[mid]) {
                if (arr[l] > target || arr[mid] < target) {
                    l = mid;
                } else {
                    l = l + 1;
                    r = mid;
                }
            } else {
                if (arr[l] > target && arr[mid] < target) {
                    l = mid;
                } else {
                    l = l + 1;
                    r = mid;
                }
            }
        }
        return result;
    }
}