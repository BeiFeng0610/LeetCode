class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int sIdx = 0, eIdx = 0;
        for (int i = 2; i <= len; i++) {
            for (int left = 0; left <= len - i; left++) {
                int right = left + i - 1;
                if (s.charAt(left) == s.charAt(right)) {
                    if (right - left < 3) {
                        dp[left][left + i - 1] = true;
                        sIdx = left;
                        eIdx = right;
                    } else if (dp[left + 1][right - 1]) {
                        dp[left][left + i - 1] = true;
                        sIdx = left;
                        eIdx = right;
                    }
                }
            }
        }
        return s.substring(sIdx, eIdx + 1);
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int len = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < 2 * len - 1; i++) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l - 2 > end - start) {
                start = l + 1;
                end = r - 1;
            }
        }
        return s.substring(start, end + 1);
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}


