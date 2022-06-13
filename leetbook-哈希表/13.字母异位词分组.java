class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] ints = strToInt(str);
            // 拼接出来一个key
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (ints[i] != 0) {
                    sb.append((char) 'a' + i);
                    sb.append(ints[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);

        }
        return new ArrayList<>(map.values());

    }

    // 用数组标记字母个数和分布
    private int[] strToInt(String str){
        int[] ans = new int[26];
        for (int i = 0; i < str.length(); i++) {
            ans[str.charAt(i) - 'a']++;
        }
        return ans;
    }
}

class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            // 把所有的字符排序，就变成key了
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
