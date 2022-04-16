class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> fuzhu;

    public MaxQueue() {
        queue = new LinkedList<>();
        fuzhu = new LinkedList<>();
    }

    
    public int max_value() {
        return fuzhu.isEmpty() ? -1 : fuzhu.peekFirst();
    }
    
    public void push_back(int value) {
        queue.offer(value);
        while (!fuzhu.isEmpty() && fuzhu.peekLast() < value) {
            fuzhu.pollLast();
        }
        fuzhu.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        if (queue.peek().equals(fuzhu.peekFirst())) {
            fuzhu.pollFirst();
        }
        return queue.poll();
    }
}
