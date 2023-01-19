import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class SortedStack {
    private Deque<Integer> stack;
    private Deque<Integer> tmpStack;
    public SortedStack() {
        stack = new LinkedList<>();
        tmpStack = new LinkedList<>();
    }

    public void push(int val) {
        while (!stack.isEmpty() && stack.peek() < val) {
            tmpStack.push(stack.pop());
        }
        stack.push(val);
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
    }

    public void pop() {
        if (!isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        return !isEmpty() ? stack.peek() : -1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}


class SortedStack {
    private Deque<Integer> mins;
    private Deque<Integer> maxs;

    public SortedStack() {
        mins = new LinkedList<>();
        maxs = new LinkedList<>();
    }

    public void push(int val) {
        if(maxs.isEmpty()) {
            mintomax(val);
        } else {
            if(val < maxs.peek()) {
                while(!maxs.isEmpty() && maxs.peek() > val) {
                    mins.push(maxs.pop());
                }
                maxs.push(val);
            } else {
                mintomax(val);
            }
        }

    }

    private void mintomax(int val) {
        while(!mins.isEmpty() && mins.peek() < val) {
            maxs.push(mins.pop());
        }
        mins.push(val);
    }

    public void pop() {
        while(!maxs.isEmpty()) {
            mins.push(maxs.pop());
        }
        if(!mins.isEmpty()) {
            mins.pop();
        }
    }
    public int peek() {
        while(!maxs.isEmpty()) {
            mins.push(maxs.pop());
        }
        return !mins.isEmpty() ? mins.peek() : -1;
    }

    public boolean isEmpty() {
        return mins.isEmpty() && maxs.isEmpty();
    }
}
/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */