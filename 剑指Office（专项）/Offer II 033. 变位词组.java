class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        // map，value存放list集合
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char[] chars = strs[i].toCharArray();
            // 字符串排序
            Arrays.sort(chars);
            String s = new String(chars);
            // 放到哈希表，如果不存在则新建一个哈希表，放入排序之前的元素
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            // 存在，则继续添加。
            map.get(s).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
