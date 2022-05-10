class KthLargest {

    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.offer(n);
        }
    }

    public int add(int val) {
        queue.offer(val);
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
