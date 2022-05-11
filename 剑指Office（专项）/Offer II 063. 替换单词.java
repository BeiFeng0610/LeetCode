class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] strings = sentence.split(" ");

        for (String pre : dictionary) {
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

    TrieNode root = new TrieNode();
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = new String[dictionary.size()];
        for (int i = 0; i < words.length; i++) {
            words[i] = dictionary.get(i);
        }

        for (String word : words) {
            insert(root, word);
        }

        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (search(root, strs[i])) {
                strs[i] = replace(strs[i], root);
            }
        }

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
            if(node.isValid) {
                break;
            }
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
            if(node.isValid || node.kids[ch - 'a'] == null) {
                break;
            }
            node = node.kids[ch - 'a'];
            sb.append(ch);
        }
        return sb.toString();
    }
}
