class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int area = 0;

        while (left < right) {
            int l = height[left];
            int r = height[right];
            int h = Math.min(l, r);
            area = Math.max(area, h * (right - left));
            while (height[left] <= h && left < right) {
                left++;
            }
            while (height[right] <= h && left < right) {
                right--;
            }
        }

        return area;
    }
}
