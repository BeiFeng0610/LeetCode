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
        // 加入队列
        queue.offer(val);
        // 计算总和
        sum += val;
        // 队列size大于>窗口宽度则总和减去队头
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
        // 循环数组
        int idx = count % size;
        // count<size时 queue[idx] 总是为0，因为还没有添加
        sum = sum + val - queue[idx];
        // count>size时，覆盖
        queue[idx] = val;
        count++;
        return sum * 1.0 / Math.min(count, size);
    }
}
