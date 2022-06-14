class KthLargest {

    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        // 依次把元素放进优先队列
        queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.offer(n);
        }
    }

    public int add(int val) {
        // 添加元素，把元素弹出到剩余k个元素，然后弹出第一个元素即可
        queue.offer(val);
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
