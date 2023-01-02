class Solution {
    // 回去等通知法
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (num > queue.peek()){
                queue.poll();
                queue.add(num);
            }
        }
        return queue.peek();
    }
}
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        // 构建大顶堆
        buildMaxHeap(nums, heapSize);
        // 删除k-1次大顶，新顶就是第k大的数
        for (int i = nums.length - 1; i >= nums.length - 1 - k; i--) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        // 找到最后一个非叶子节点 下标从0开始 需要-1
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            // 小数下沉
            maxHeapify(a, i, heapSize);
        }
    }
    public void maxHeapify(int[] a, int i, int heapSize) {
        // 记录父节点
        int pIdx = i;
        // 找到左右孩子的下标
        int l = i * 2 + 1, r = i * 2 + 2;
        // 判断是否大于父节点，更新pIdx等待交换即可
        if (l < heapSize && a[l] > a[pIdx]) {
            pIdx = l;
        }
        if (r < heapSize && a[r] > a[pIdx]) {
            pIdx = r;
        }
        if (pIdx != i) {
            // 更新父 子结点
            swap(a, i, pIdx);
            // 父节点下沉后，继续判断下沉
            maxHeapify(a, pIdx, heapSize);
        }
    }
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
class Solution3 {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        // 获取随机基准下标
        int q = randomPartition(a, l, r);
        // 等于index就直接返回
        if (q == index) {
            return a[q];
        } else {
            // 大于index就在基准数左边区间继续找，小于就去右边找
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        // 随机获取一个[l,r]区间的下标
        int i = random.nextInt(r - l + 1) + l;
        // 把随机到的下标放到右边界，作为基准数
        swap(a, i, r);
        // 比较基准数分割，返回基准数下标
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        // 获取基准数，左边界为l-1，因为l还没有确定
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            // 小于基准就放到左边，大于就不用管
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        // 确定基准数下标
        swap(a, i + 1, r);
        // 返回基准数下标
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
