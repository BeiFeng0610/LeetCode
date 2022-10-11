import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int cur = temperatures[i];
            while (!stack.isEmpty() && cur > temperatures[stack.peek()]) {
                int pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }
}