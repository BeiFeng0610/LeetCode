import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] masterMind(String solution, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = solution.toCharArray();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int ag = 0, g = 0;
        char[] gChars = guess.toCharArray();
        for (char c : gChars) {
            if (map.containsKey(c) && map.get(c) > 0) {
                ag++;
                map.put(c, map.get(c) - 1);
            }
        }

        for (int i = 0; i < gChars.length; i++) {
            if (gChars[i] == chars[i]) {
                g++;
            }
        }
        return new int[]{g, ag - g};
    }
}

class Solution {
    public int[] masterMind(String solution, String guess) {

        int fake = 0, real = 0;

        int[] map = new int[26];

        for(int i = 0; i < 4; i++){
            char sol = solution.charAt(i), gue = guess.charAt(i);

            if(sol == gue) {
                real++;
            } else{
                if(map[sol - 'A'] < 0) {
                    fake++;
                }
                map[sol - 'A']++;

                if(map[gue - 'A'] > 0) {
                    fake++;
                }
                map[gue - 'A']--;
            }
        }
        return new int[]{real, fake};
    }
}
