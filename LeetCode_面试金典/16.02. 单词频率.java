class WordsFrequency {
    private Node tree;
    public WordsFrequency(String[] book) {
        tree = new Node();
        for (String s : book) {
            save(s);
        }
    }

    public int get(String word) {
        return find(word);
    }

    private int find(String s) {
        Node cur = tree;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (cur.next[idx] == null) {
                return 0;
            }
            cur = cur.next[idx];
        }
        return cur.count;
    }

    private void save(String s) {
        Node cur = tree;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new Node();
            }
            cur = cur.next[idx];
        }
        cur.isEnd = true;
        cur.count++;
    }

    static class Node{
        Node[] next = new Node[26];
        boolean isEnd = false;
        int count = 0;
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */