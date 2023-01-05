import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }
}

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[256];
        int count = 0;
        for (char c : s.toCharArray()) {
            if ((++map[c] & 1) == 1) {
                count++;
            } else {
                count--;
            }
        }
        return count <= 1;
    }
}