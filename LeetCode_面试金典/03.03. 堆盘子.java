import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class StackOfPlates {
    private List<Deque<Integer>> stacks;
    private int cap;

    public StackOfPlates(int cap) {
        stacks = new LinkedList<>();
        this.cap = cap;
    }

    public void push(int val) {
        if (cap == 0) {
            return;
        }
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == cap) {
            Deque<Integer> stack = new LinkedList<>();
            stack.push(val);
            stacks.add(stack);
        } else {
            Deque<Integer> stack = stacks.get(stacks.size() - 1);
            stack.push(val);
        }
    }

    public int pop() {
        if (stacks.isEmpty()) {
            return -1;
        }
        Deque<Integer> stack = stacks.get(stacks.size() - 1);
        int pop = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return pop;
    }

    public int popAt(int index) {
        if (stacks.isEmpty() || index >= stacks.size()) {
            return -1;
        }
        Deque<Integer> stack = stacks.get(index);
        int pop = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(index);
        }
        return pop;
    }
}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */