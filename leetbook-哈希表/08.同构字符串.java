class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(sLen);
        Set<Character> set = new HashSet<>();

        // 一一映射
        for (int i = 0; i < sLen; i++) {
            if (!map.containsKey(s.charAt(i)) && !set.contains(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            } else if (map.get(s.charAt(i)) == null || map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        // 判断字母第一次出现的映射关系
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
