class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int L = 0, R = len - 1;
        int max = 0;
        while (L < R) {
            int area = (R - L) * Math.min(height[L], height[R]);
            max = Math.max(max, area);
            if (height[L] <= height[R]) {
                L++;
            } else {
                R--;
            }
        }
        return max;
    }
}

class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int L = 0, R = len - 1;
        int max = 0;
        while (L < R) {
            int min = Math.min(height[L], height[R]);
            int area = (R - L) * min;
            max = Math.max(max, area);
            while (height[L] <= min && L < R) {
                L++;
            }
            while (height[R] <= min && L < R) {
                R--;
            }
        }
        return max;
    }
}
