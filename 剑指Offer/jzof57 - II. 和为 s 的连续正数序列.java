package 剑指Offer;

class Solution {
    public int[][] findContinuousSequence(int target) {
        if (target < 3 || (target & target - 1) == 0) {
            return new int[0][];
        }
        int l = 1, r = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while (l < r) {
            if (s == target) {
                int[] ans = new int[r - l + 1];
                for (int k = l; k <= r; k++) {
                    ans[k - l] = k;
                }
                res.add(ans);
            }
            if (s >= target) {
                s -= l;
                l++;
            } else {
                r++;
                s += r;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
