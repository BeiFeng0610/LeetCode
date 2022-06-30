import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    PriorityQueue<Double> queue1 = new PriorityQueue<>(new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return (int) (o2 - o1);
        }
    });
    PriorityQueue<Double> queue2 = new PriorityQueue<>();
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        for (int num : nums1) {
            pri(num);
        }
        for (int num : nums2) {
            pri(num);
        }
        if (queue1.size() != queue2.size()) {
            return queue1.size() > queue2.size() ? queue1.element() : queue2.element();
        } else {
            return (queue2.element() + queue1.element()) / 2;
        }
    }
    public void pri(double num) {
        if (queue1.size() == 0) {
            queue1.offer(num);
            return;
        }
        if (num > queue1.peek()) {
            queue2.offer(num);
            if (queue2.size() > queue1.size() + 1) {
                double poll = queue2.poll();
                queue1.offer(poll);
            }
        } else {
            queue1.offer(num);
            if (queue1.size() > queue2.size() + 1) {
                double poll = queue1.poll();
                queue2.offer(poll);
            }
        }
    }
}