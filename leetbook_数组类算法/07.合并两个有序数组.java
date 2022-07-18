class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int l = 0, r = 0, cur = 0;
        while (l < m || r < n) {
            if (l == m) {
                cur = nums2[r++];
            } else if (r == n || nums1[l] < nums2[r]) {
                cur = nums1[l++];
            } else {
                cur = nums2[r++];
            }
            sort[l + r - 1] = cur;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sort[i];
        }
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        while (p2 >= 0) {
            if (p1 < 0 || nums1[p1] <= nums2[p2]) {
                nums1[tail--] = nums2[p2--];
            } else {
                nums1[tail--] = nums1[p1--];
            }
        }
    }
}
