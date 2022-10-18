import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Character, char[]> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        back(digits, 0);
        return res;
    }

    private void back(String digits, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char[] chars = map.get(digits.charAt(idx));
        for (char ch : chars) {
            sb.append(ch);
            back(digits, idx + 1);
            sb.deleteCharAt(idx);
        }
    }
}