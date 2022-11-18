import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
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


class MinStack {

    private Node cur;

    public MinStack() {

    }

    public void push(int val) {
        if (cur == null) {
            cur = new Node(val, val);
        } else {
            Node node = new Node(val, Math.min(val, cur.min));
            node.pre = cur;
            cur = node;
        }
    }

    public void pop() {
        cur = cur.pre;
    }

    public int top() {
        return cur.val;
    }

    public int getMin() {
        return cur.min;
    }

    private class Node{
        int val;
        int min;
        Node pre;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public Node(int val, int min, Node pre) {
            this.val = val;
            this.min = min;
            this.pre = pre;
        }
    }
}

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */