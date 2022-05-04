class MovingAverage {
    Queue<Integer> queue;
    int size;
    double sum = 0.0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > size) {
            sum -= queue.poll();
        }
        return sum / Math.min(queue.size(), size);
    }
}
class MovingAverage2 {
    int size,sum = 0, count = 0;
    int [] queue;
    /** Initialize your data structure here. */
    public MovingAverage2(int size) {
        this.size = size;
        queue = new int[size];
    }

    public double next(int val) {
        int idx = count % size;
        sum = sum + val - queue[idx];
        queue[idx] = val;
        count++;
        return sum * 1.0 / Math.min(count, size);
    }
}
