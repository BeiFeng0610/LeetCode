class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (n < m) {
            return res;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            --cnt[p.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < n; ++right) {
            int x = s.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == m) {
                res.add(left);
            }
        }
        return res;
    }
}
