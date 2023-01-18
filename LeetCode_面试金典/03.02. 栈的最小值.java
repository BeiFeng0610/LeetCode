import java.util.Deque;
import java.util.LinkedList;

class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int pop = stack.pop();
        if (!minStack.isEmpty() && pop == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */