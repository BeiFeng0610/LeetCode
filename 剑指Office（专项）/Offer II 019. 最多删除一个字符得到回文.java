class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char c1 = s.charAt(l), c2 = s.charAt(r);
            if (c1 != c2) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            char c1 = s.charAt(l), c2 = s.charAt(r);
            if (c1 != c2) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
