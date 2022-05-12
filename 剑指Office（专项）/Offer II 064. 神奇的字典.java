class MagicDictionary {
    Set<String> words;
    Map<String, Integer> neighborCount;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        words = new HashSet<>();
        neighborCount = new HashMap<>();
    }

    public String[] getNeighbors(String word) {
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
        for (String word : dictionary) {
            words.add(word);
            for (String neighbor : getNeighbors(word)) {
                neighborCount.put(neighbor, neighborCount.getOrDefault(neighbor, 0) + 1);
            }
        }
    }

    public boolean search(String searchWord) {
        for (String neighbor : getNeighbors(searchWord)) {
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
