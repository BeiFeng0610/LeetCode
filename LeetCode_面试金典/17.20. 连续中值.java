import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> minQueue;
    private PriorityQueue<Integer> maxQueue;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (maxQueue.isEmpty()) {
            maxQueue.offer(num);
            return;
        }
        if (num > findMedian()) {
            if (minQueue.size() > maxQueue.size()) {
                maxQueue.offer(minQueue.poll());
            }
            minQueue.offer(num);
        } else {
            if (maxQueue.size() > minQueue.size()) {
                minQueue.offer(maxQueue.poll());
            }
            maxQueue.offer(num);
        }
    }

    public double findMedian() {
        if (minQueue.isEmpty() && maxQueue.isEmpty()) {
            return 0;
        }
        if (minQueue.size() == maxQueue.size()) {
            return (double) (minQueue.peek() + maxQueue.peek()) / 2;
        }
        return minQueue.size() > maxQueue.size() ? minQueue.peek() : maxQueue.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */