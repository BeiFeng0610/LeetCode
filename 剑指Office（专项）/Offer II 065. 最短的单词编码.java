class Solution {
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (String word : words) {
            len += trie.insert(word);
        }
        return len;
    }
}

class Trie{
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public int insert(String word) {
        TrieNode cur = root;
        boolean isNew = false;
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                isNew = true;
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        return isNew ? word.length() + 1 : 0;
    }
}

class TrieNode{
    char val;
    TrieNode[] children = new TrieNode[26];
    public TrieNode(){}
}
/*-----------------------------------------------------------------*/
class Solution2 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet<String>(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k) {
                good.remove(word.substring(k));
            }
        }

        int ans = 0;
        for (String word: good) {
            ans += word.length() + 1;
        }
        return ans;
    }
}
