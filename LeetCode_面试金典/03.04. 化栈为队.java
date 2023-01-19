import java.util.Deque;
import java.util.LinkedList;

class MyQueue {
    private Deque<Integer> stack;
    private Deque<Integer> tmpStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new LinkedList<>();
        tmpStack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }
        return tmpStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }
        return tmpStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && tmpStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */