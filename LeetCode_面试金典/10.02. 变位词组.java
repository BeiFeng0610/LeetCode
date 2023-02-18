import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String encode = encode(str);
            map.putIfAbsent(encode, new ArrayList<>());
            map.get(encode).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String encode(String str) {
        char[] ch = new char[26];
        for (char c : str.toCharArray()) {
            ch[c - 'a']++;
        }
        return new String(ch);
    }
}