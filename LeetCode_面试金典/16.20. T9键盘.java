import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] key = new int[]{2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};

    public List<String> getValidT9Words(String num, String[] words) {
        int n = num.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = num.charAt(i) - '0';
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isValid(word, nums, key)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isValid(String word, int[] nums, int[] key) {
        if (word.length() != nums.length) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (key[word.charAt(i) - 'a'] != nums[i]) {
                return false;
            }
        }
        return true;
    }
}