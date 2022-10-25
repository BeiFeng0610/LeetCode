class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            int maxL = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxL = Math.max(maxL, height[j]);
            }

            int maxR = 0;
            for (int j = i + 1; j < len; j++) {
                maxR = Math.max(maxR, height[j]);
            }

            int min = Math.min(maxL, maxR);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}

class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int len = height.length;
        int[] maxL = new int[len];
        int[] maxR = new int[len];

        for (int i = 1; i < len - 1; i++) {
            maxL[i] = Math.max(maxL[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i > 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], height[i + 1]);
        }

        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(maxL[i], maxR[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
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

        //for (int i = 1; i < len - 1; i++) {
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

