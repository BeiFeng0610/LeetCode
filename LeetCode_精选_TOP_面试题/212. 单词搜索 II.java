import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();
    Set<String> set = new HashSet<>();
    int row;
    int cols;

    public List<String> findWords(char[][] board, String[] words) {
        row = board.length;
        cols = board[0].length;
        for (String word : words) {
            if (set.contains(word)) {
                res.add(word);
                continue;
            }
            char ch = word.charAt(0);
            boolean flag = false;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == ch) {
                        flag = dfs(board, i, j, word, 0);
                    }
                    if (flag) break;
                }
                if (flag) break;
            }
        }
        return res;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int idx) {
        if (i < 0 || i >= row || j < 0 || j >= cols || board[i][j] != word.charAt(idx)) {
            return false;
        }
        if (idx == word.length() - 1) {
            res.add(word);
            set.add(word);
            return true;
        }
        char ch = word.charAt(idx);
        board[i][j] = '0';
        return dfs(board, i + 1, j, word, idx + 1) && (board[i][j] = ch) != '0' ||
                dfs(board, i - 1, j, word, idx + 1) && (board[i][j] = ch) != '0' ||
                dfs(board, i, j + 1, word, idx + 1) && (board[i][j] = ch) != '0' ||
                dfs(board, i, j - 1, word, idx + 1) && (board[i][j] = ch) != '0' || (board[i][j] = ch) == '0';
    }
}


class Solution {

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, ans);
            }
        }
        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, Trie now, int i1, int j1, Set<String> ans) {
        if (!now.children.containsKey(board[i1][j1])) {
            return;
        }
        char ch = board[i1][j1];
        now = now.children.get(ch);
        if (!"".equals(now.word)) {
            ans.add(now.word);
        }

        board[i1][j1] = '#';
        for (int[] dir : dirs) {
            int i2 = i1 + dir[0], j2 = j1 + dir[1];
            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                dfs(board, now, i2, j2, ans);
            }
        }
        board[i1][j1] = ch;

    }
}

class Trie{
    String word;
    Map<Character, Trie> children;
    boolean isWord;

    public Trie(){
        this.word = "";
        this.children = new HashMap<>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}