import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[][] multiSearch(String big, String[] smalls) {
        List<int[]> list = new ArrayList<>();
        if (smalls.length == 0) {
            return list.toArray(new int[0][0]);
        }
        for (String small : smalls) {
            if (small.length() == 0) {
                list.add(new int[0]);
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            int start = 0;
            while (start < big.length()) {
                start = big.indexOf(small, start);
                if (start < 0) {
                    break;
                }
                tmp.add(start);
                start++;
            }
            int size = tmp.size();
            int[] tint = new int[size];
            for (int i = 0; i < tmp.size(); i++) {
                tint[i] = tmp.get(i);
            }
            list.add(tint);
        }
        return list.toArray(new int[0][]);
    }
}


class Solution {
    static class TrieNode{
        String end;
        TrieNode[] next = new TrieNode[26];
    }

    static class Trie{
        TrieNode root;

        public Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode node = root;
                for (char ch : word.toCharArray()) {
                    int idx = ch - 'a';
                    if (node.next[idx] == null) {
                        node.next[idx] = new TrieNode();
                    }
                    node = node.next[idx];
                }
                node.end = word;
            }
        }

        public List<String> search(String big) {
            List<String> list = new ArrayList<>();
            TrieNode node = root;
            for (char ch : big.toCharArray()) {
                int idx = ch - 'a';
                if (node.next[idx] == null) {
                    break;
                }
                node = node.next[idx];
                if (node.end != null) {
                    list.add(node.end);
                }
            }
            return list;
        }
    }

    public int[][] multiSearch(String big, String[] smalls) {
        Trie trie = new Trie(smalls);
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < big.length(); i++) {
            List<String> matchs = trie.search(big.substring(i));
            for (String word : matchs) {
                if (!map.containsKey(word)) {
                    map.put(word, new ArrayList<>());
                }
                map.get(word).add(i);
            }
        }

        int len = smalls.length;
        int[][] res = new int[len][];
        for (int i = 0; i < len; i++) {
            List<Integer> list = map.get(smalls[i]);
            if (list == null) {
                res[i] = new int[0];
                continue;
            }
            int size = list.size();
            res[i] = new int[size];
            for (int j = 0; j < size; j++) {
                res[i][j] = list.get(j);
            }
        }
        return res;
    }
}