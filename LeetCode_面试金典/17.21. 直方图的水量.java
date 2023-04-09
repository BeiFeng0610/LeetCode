class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftHigh = new int[len];
        int[] rightHigh = new int[len];
        for (int i = 1; i < len; i++) {
            leftHigh[i] = Math.max(leftHigh[i - 1], height[i - 1]);
            rightHigh[len - 1 - i] = Math.max(rightHigh[len - i], height[len - i]);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.max(Math.min(leftHigh[i], rightHigh[i]) - height[i], 0);
        }
        return res;
    }
}

class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int len = height.length;
        int maxL = 0;
        int maxR = 0;
        int left = 1;
        int right = len - 2;

        while (left <= right) {
            if (height[left - 1] < height[right + 1]) {
                maxL = Math.max(maxL, height[left - 1]);
                int min = maxL;
                if (min > height[left]) {
                    sum += (min - height[left]);
                }
                left++;
            } else {
                maxR = Math.max(maxR, height[right + 1]);
                int min = maxR;
                if (min > height[right]) {
                    sum += (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}