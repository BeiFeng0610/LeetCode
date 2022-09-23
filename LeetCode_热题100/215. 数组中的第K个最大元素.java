import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, i, 0);
            --heapSize;
            maxHeap(nums, heapSize, 0);
        }
        return nums[0];
    }

    private void buildHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeap(nums, heapSize, i);
        }
    }

    private void maxHeap(int[] nums, int heapSize, int i) {
        int left = i * 2 + 1, right = left + 1;
        int largest = i;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxHeap(nums, heapSize, largest);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = nums[i];
        }
        buildHeap(arr, k);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > arr[0]) {
                arr[0] = nums[i];
                heapify(arr, k, 0);
            }
        }
        return arr[0];
    }
    private void buildHeap(int[] nums, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
    }
    private void heapify(int[] nums, int n, int i) {
        while (true) {
            int minPos = i, left = 2 * i + 1, right = left + 1;
            if (left < n && nums[minPos] > nums[left]) minPos = left;
            if (right < n && nums[minPos] > nums[right]) minPos = right;
            if (minPos == i) break;
            swap(nums, i, minPos);
            i = minPos;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//-----------------------------------------
class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}