class Solution {
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 把所有单词按长度降序排列
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (String word : words) {
            len += trie.insert(word);
        }
        return len;
    }
}

class Trie{
    TrieNode root;
    // 初始化根节点
    public Trie(){
        root = new TrieNode();
    }
    public int insert(String word) {
        TrieNode cur = root;
        boolean isNew = false;
        // 然后倒序插入每个单词，如果
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                isNew = true;
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        // 是新单词就返回长度+1
        return isNew ? word.length() + 1 : 0;
    }
}

// 字典结点
class TrieNode{
    char val;
    TrieNode[] children = new TrieNode[26];
    public TrieNode(){}
}
/*-----------------------------------------------------------------*/
class Solution2 {
    public int minimumLengthEncoding(String[] words) {
        // 往set中存入所有单词，不重复
        Set<String> good = new HashSet<String>(Arrays.asList(words));
        // 暴力枚举，删除某个单词的所有前缀单词。
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k) {
                good.remove(word.substring(k));
            }
        }
        // 然后计算剩下单词即可
        int ans = 0;
        for (String word: good) {
            ans += word.length() + 1;
        }
        return ans;
    }
}
