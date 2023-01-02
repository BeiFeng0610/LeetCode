class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int l = 0, r = len - 1;
        // 双指针
        while (l < r) {
            // 寻找右指针和左指针有效位，比较即可
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l < r) {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                ++l;
                --r;
            }
        }
        return true;
    }
}
