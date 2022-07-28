import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    List<String> combinations;
    Map<Character, String> phoneMap;

    public List<String> letterCombinations(String digits) {
        combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder());
        return combinations;
    }

    public void backtrack(String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {
            combination.append(letters.charAt(i));
            backtrack(digits, index + 1, combination);
            combination.deleteCharAt(index);
        }

    }
}