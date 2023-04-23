class Solution {
    int r;
    int c;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        r = board.length;
        c = board[0].length;
        char[] chars = word.toCharArray();
        int head = 0;
        int len = chars.length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == chars[0]) {
                    head++;
                } else if (board[i][j] == chars[len - 1]) {
                    head--;
                }
            }
        }
        if (head > 0) {
            char[] temp = new char[len];
            for (int i = 0; i < len; i++) {
                temp[i] = chars[len - 1 - i];
            }
            chars = temp;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == chars[0]) {
                    if (bfs(chars, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean bfs(char[] word, int idx, int i, int j) {
        if (i < 0 || i >= r || j < 0 || j >= c || board[i][j] != word[idx]) {
            return false;
        }
        if (idx == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean tag = bfs(word, idx + 1, i + 1, j) ||
                bfs(word, idx + 1, i - 1, j) ||
                bfs(word, idx + 1, i, j + 1) ||
                bfs(word, idx + 1, i, j - 1);
        board[i][j] = word[idx];
        return tag;
    }
}