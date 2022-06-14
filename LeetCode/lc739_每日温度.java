/*
*   单调栈：
*       栈为空，压入数组下标
*       如果栈不空，获取后数下标，循环对比栈顶下标元素
*       后数大于栈顶下标元素：弹出栈顶元素相减即可。
* */
public int[] dailyTemperatures(int[] temperatures) {
    int len = temperatures.length;
    int[] ans = new int[len];
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i < ans.length; i++) {
        int temp = temperatures[i];
        while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
            int preIndex = stack.pop();
            ans[preIndex] = i - preIndex;
        }
        stack.push(i);
    }
    return ans;
}
