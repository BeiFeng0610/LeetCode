package 剑指Offer第2版;

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int p : prices) {
            min = Math.min(p, min);
            max = Math.max(max, p - min);
        }
        return max;
    }
}
