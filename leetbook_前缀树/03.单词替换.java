import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    class TrieNode{
        Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        initTrie(root, dictionary);
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = findRoot(strings[i], root);
        }

        return String.join(" ", strings);
    }

    /**
     * 初始化字典，# 标识词根结束。
     * @param root
     * @param dictionary
     */
    public void initTrie(TrieNode root, List<String> dictionary) {
        for (String word : dictionary) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                cur.children.putIfAbsent(ch, new TrieNode());
                cur = cur.children.get(ch);
            }
            cur.children.put('#', new TrieNode());
        }
    }

    public String findRoot(String word, TrieNode root) {
        StringBuilder sb = new StringBuilder();
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 如果碰到 # 说明词根匹配完了，直接返回即可
            if (cur.children.containsKey('#')) {
                return sb.toString();
            }
            // 如果突然匹配中断，直接返回整个字符串
            if (!cur.children.containsKey(c)) {
                return word;
            }
            sb.append(c);
            cur = cur.children.get(c);
        }
        return sb.toString();
    }
}





















