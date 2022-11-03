import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Deque<Integer> monoStack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                right[monoStack.peek()] = i;
                monoStack.pop();
            }
            left[i] = (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}