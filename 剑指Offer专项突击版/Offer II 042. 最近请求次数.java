class RecentCounter {
    Deque<Integer> deque;

    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        // 添加元素
        deque.addLast(t);
        // 不用判空，因为没有删除元素
        while (deque.getFirst() < t - 3000) {
            deque.removeFirst();
        }
        return deque.size();
    }
}
