class MapSum {
    Map<String, Integer> words;
    /** Initialize your data structure here. */
    public MapSum() {
        words = new HashMap<>();
    }

    public void insert(String key, int val) {
        words.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        Set<String> strings = words.keySet();
        for (String s : strings) {
            if (s.indexOf(prefix) == 0) {
                sum += words.get(s);
            }
        }
        return sum;
    }
}
class MapSum2 {
    class TrieNode {
        int val = 0;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root;
    Map<String, Integer> map;

    public MapSum2() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
            node.val += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return 0;
            }
            node = node.next[c - 'a'];
        }
        return node.val;
    }
}
