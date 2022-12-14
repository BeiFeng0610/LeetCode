import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> maxQueue;
    private PriorityQueue<Integer> minQueue;

    public MedianFinder() {
        this.maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        this.minQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        if (maxQueue.isEmpty()) {
            maxQueue.offer(num);
            return;
        }
        if (maxQueue.size() > minQueue.size()) {
            if (num >= maxQueue.peek()) {
                minQueue.offer(num);
            } else {
                int poll = maxQueue.poll();
                minQueue.offer(poll);
                maxQueue.offer(num);
            }
        } else {
            if (num <= minQueue.peek()) {
                maxQueue.offer(num);
            } else {
                int poll = minQueue.poll();
                minQueue.offer(num);
                maxQueue.offer(poll);
            }
        }
    }

    public double findMedian() {
        if (maxQueue.size() > minQueue.size()) {
            return maxQueue.peek();
        } else if (maxQueue.size() < minQueue.size()) {
            return minQueue.peek();
        } else {
            return (maxQueue.peek() + minQueue.peek()) / 2.0;
        }
    }
}

class MedianFinder {
    private PriorityQueue<Integer> maxQueue;
    private PriorityQueue<Integer> minQueue;

    public MedianFinder() {
        this.maxQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        this.minQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (maxQueue.isEmpty() || num > maxQueue.peek()) {
            maxQueue.offer(num);
            if (minQueue.size() + 1 < maxQueue.size()) {
                minQueue.offer(maxQueue.poll());
            }
        } else {
            minQueue.offer(num);
            if (minQueue.size() > maxQueue.size()) {
                maxQueue.offer(minQueue.poll());
            }
        }
    }

    public double findMedian() {
        if (maxQueue.size() > minQueue.size()) {
            return maxQueue.peek();
        } else {
            return (maxQueue.peek() + minQueue.peek()) / 2.0;
        }
    }
}
