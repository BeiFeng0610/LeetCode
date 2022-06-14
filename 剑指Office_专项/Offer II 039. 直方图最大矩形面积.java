class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 记录每个矩形的左边界
        int[] left = new int[n];
        // 记录每个矩形的右边界
        int[] right = new int[n];
        // 初始化所有右边界默认为最右边
        Arrays.fill(right, n);
        
        Deque<Integer> mono_stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            // 如果栈不空，且左高度大于等于当前高度，则依次弹栈，弹出高度的右边界为当前下标，因为当前高度小于左高度，不能加入计算了。
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            // 如果左边所有数都大于当前高度，则栈必为空，左边界为-1，如果左高度小于当前，则左边界就为左下标。
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
            // 如果所有数都呈递增，其左边界即为左数，右边界为最大。
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            // 计算当前高度的宽度，因为下标从0开始所以最左边界为-1，所以宽度等于左边界-右边界-1。
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new 剑指Office.Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }
}
