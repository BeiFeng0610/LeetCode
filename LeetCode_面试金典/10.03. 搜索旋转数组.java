class Solution {
    public int search(int[] arr, int target) {
        int len = arr.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[l] == target) {
                return l;
            }
            if (arr[l] == arr[mid]) {
                l++;
            } else if (arr[l] < arr[mid]) {
                if (target < arr[l] || target > arr[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                if (target < arr[l] && target > arr[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return arr[l] == target ? l : -1;
    }
}