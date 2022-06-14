class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] strings = sentence.split(" ");

        for (String pre : dictionary) {
            // 暴力枚举，startsWith判断是否包含，然后替换。
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].startsWith(pre)) {
                    strings[i] = pre;
                }
            }
        }

        return String.join(" ", strings);
    }

}

class Solution2 {

    class TrieNode{
        TrieNode[] kids;
        boolean isValid;
        public TrieNode(){
            kids = new TrieNode[26];
        }
    }

    // 字典树根节点。
    TrieNode root = new TrieNode();
    public String replaceWords(List<String> dictionary, String sentence) {
        // 获取所有前缀
        String[] words = new String[dictionary.size()];
        for (int i = 0; i < words.length; i++) {
            words[i] = dictionary.get(i);
        }
        // 全部加入字典树
        for (String word : words) {
            insert(root, word);
        }
        
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (search(root, strs[i])) {
                strs[i] = replace(strs[i], root);
            }
        }

        // 拼接所有字符串
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public void insert(TrieNode root, String s){
        TrieNode node = root;
        for(char ch : s.toCharArray()){
            if(node.kids[ch - 'a'] == null) {
                node.kids[ch - 'a'] = new TrieNode();
            }
            node = node.kids[ch - 'a'];
        }
        node.isValid = true;
    }

    public boolean search(TrieNode root, String s){
        TrieNode node = root;
        for(char ch : s.toCharArray()){
            // 包含词根直接返回
            if(node.isValid) {
                break;
            }
            // 单词不包含词根
            if(node.kids[ch - 'a'] == null) {
                return false;
            }
            node = node.kids[ch - 'a'];
        }
        return true;
    }

    public String replace(String s, TrieNode root){
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            // 包含词根，或者遍历结束不包含，就返回
            if(node.isValid || node.kids[ch - 'a'] == null) {
                break;
            }
            node = node.kids[ch - 'a'];
            // 拼接当前字母
            sb.append(ch);
        }
        return sb.toString();
    }
}
