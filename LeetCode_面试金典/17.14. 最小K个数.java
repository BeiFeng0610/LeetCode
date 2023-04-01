import java.util.PriorityQueue;
import java.util.Random;

class Solution {
    public int[] smallestK(int[] arr, int k) {
        int len = arr.length;
        int size = len - k;
        int[] res = new int[k];
        int idx = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            queue.offer(num);
            if (queue.size() > size) {
                res[idx++] = queue.poll();
            }
        }
        return res;
    }
}

class Solution {
    int K;

    public int[] smallestK(int[] arr, int k) {
        K = k;
        int n = arr.length;
        int[] ans = new int[k];
        if (k == 0) {
            return ans;
        }
        qsort(arr, 0, n - 1);
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    private void qsort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        int ridx = new Random().nextInt(r - l + 1) + l;
        swap(arr, ridx, l);
        int x = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= x) {
                j--;
            }
            while (i < j && arr[i] <= x) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > K) {
            qsort(arr, l, i - 1);
        }
        if (i < K) {
            qsort(arr, i + 1, r);
        }
    }

    private void swap(int[] arr, int l, int r) {
        if (l == r) return;
        arr[l] ^= arr[r];
        arr[r] ^= arr[l];
        arr[l] ^= arr[r];
    }
}


