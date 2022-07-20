import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String reverseVowels(String s) {
        String yuan = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && yuan.indexOf(chars[l]) < 0) {
                l++;
            }
            while (l < r && yuan.indexOf(chars[r]) < 0) {
                r--;
            }
            if (l < r) {
                char c = chars[l];
                chars[l] = chars[r];
                chars[r] = c;
            }
            l++;
            r--;
        }
        return new String(chars);
    }
}