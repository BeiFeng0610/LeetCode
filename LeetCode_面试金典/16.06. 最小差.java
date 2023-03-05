import java.util.Arrays;

class Solution {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long min = Long.MAX_VALUE;
        for (long i : a) {
            int idx = search(i, b);
            for (int j = idx; j < b.length && j < idx + 3; j++) {
                long cur = Math.abs(i - b[j]);
                if (cur < min) {
                    min = cur;
                }
            }
        }
        return (int) min;
    }

    private int search(long num, int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}


class Solution {
    public int smallestDifference(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        if (n == 1 && m == 1) {
            return Math.abs(a[0] - b[0]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long min = Long.MAX_VALUE;
        int i = 0, j = 0;
        while (i < n && j < m) {
            long tmp = a[i] - b[j];
            if (tmp == 0) {
                return 0;
            }
            min = Math.min(min, Math.abs(tmp));
            if (tmp < 0) {
                i++;
            } else {
                j++;
            }
        }
        return (int) min;
    }
}