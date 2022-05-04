class RecentCounter {
    Deque<Integer> deque;

    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.addLast(t);
        while (deque.getFirst() < t - 3000) {
            deque.removeFirst();
        }
        return deque.size();
    }
}
