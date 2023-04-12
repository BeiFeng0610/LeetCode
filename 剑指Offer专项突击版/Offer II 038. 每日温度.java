class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        // 👴的暴力法，直接全部枚举出来
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (temperatures[i] < temperatures[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}

class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        // 记录每位
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        // 单调栈
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            // 栈不空，且栈顶温度小于当前温度，则用当前下标减去栈顶下标。
            while (!stack.isEmpty() &&  temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            // 栈空进栈，当前温度小于前一天温度进栈，存放的是下标
            stack.push(i);
        }
        return ans;
    }
}
