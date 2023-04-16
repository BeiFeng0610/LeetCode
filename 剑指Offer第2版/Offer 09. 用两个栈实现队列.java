import java.util.Deque;
import java.util.LinkedList;

class CQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public CQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty() && inStack.isEmpty()) {
            return -1;
        }
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */