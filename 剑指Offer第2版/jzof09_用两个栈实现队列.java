package 剑指Offer第2版;

class CQueue {
    Deque<Integer> s1;
    Deque<Integer> s2;

    public CQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s1.isEmpty() && s2.isEmpty()) {
            return -1;
        } else if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
