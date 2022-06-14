class MagicDictionary {
    // 存放所有单词，不重复
    Set<String> words;
    // 所有广义邻居
    Map<String, Integer> neighborCount;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        words = new HashSet<>();
        neighborCount = new HashMap<>();
    }

    public String[] getNeighbors(String word) {
        // 获取每个单词的所有广义邻居
        String[] neighbors = new String[word.length()];
        StringBuilder str = new StringBuilder(word);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            str.setCharAt(i, '*');
            neighbors[i] = str.toString();
            str.setCharAt(i, c);
        }
        return neighbors;
    }

    public void buildDict(String[] dictionary) {
        // 统计每个单词的广义邻居，可能为多个
        for (String word : dictionary) {
            words.add(word);
            for (String neighbor : getNeighbors(word)) {
                neighborCount.put(neighbor, neighborCount.getOrDefault(neighbor, 0) + 1);
            }
        }
    }

    public boolean search(String searchWord) {
        for (String neighbor : getNeighbors(searchWord)) {
            // 查找map中的广义邻居数量，如果大于1个，必定满足，如果有1个，判断set集合中是否包含本单词，包含则满足
            int neighborNum = neighborCount.getOrDefault(neighbor, 0);
            if (neighborNum > 1 || neighborNum == 1 && !words.contains(searchWord)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */

class MagicDictionary2 {
    List<String> words;

    /** Initialize your data structure here. */
    public MagicDictionary2() {
        words = new ArrayList<>();
    }

    public void buildDict(String[] dictionary) {
        words.addAll(Arrays.asList(dictionary));
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        // 暴力枚举，长度不同直接跳过，记录不同字母个数，等于1符合条件
        for (String s : words) {
            if (s.length() != len) {
                continue;
            }
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != searchWord.charAt(i)) {
                    count++;
                }
            }
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}
