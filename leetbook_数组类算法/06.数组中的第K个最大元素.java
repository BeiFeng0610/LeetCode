import java.util.PriorityQueue;
import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.peek();
    }
}

class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int idx) {
        int q = randomPartition(a, l, r);
        if (q == idx) {
            return a[q];
        } else {
            return q < idx ? quickSelect(a, q + 1, r, idx) : quickSelect(a, l, q - 1, idx);
        }
    }

    public int randomPartition(int[] a, int l,int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a,int l,int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}