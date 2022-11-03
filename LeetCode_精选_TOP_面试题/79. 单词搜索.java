class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char ch = word.charAt(idx);
        board[i][j] = '0';

        return helper(board, word, i + 1, j, idx + 1) ||
                helper(board, word, i - 1, j, idx + 1) ||
                helper(board, word, i, j + 1, idx + 1) ||
                helper(board, word, i, j - 1, idx + 1) ||
                (board[i][j] = ch) == '0';
    }
}