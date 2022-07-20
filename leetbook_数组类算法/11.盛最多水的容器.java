class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int mmin = Math.min(height[l], height[r]);
            int area = mmin * (r - l);
            ans = Math.max(ans, area);
            while (height[l] <= mmin && l < r) {
                l++;
            }
            while (height[r] <= mmin && l < r) {
                r--;
            }
        }
        return ans;
    }
}
