class Solution {
    char[] words;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        words = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == words[0]) {
                    if (backtrack(board, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int i, int j, int idx) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[idx]) {
            return false;
        }
        if (idx == words.length - 1) {
            return true;
        }
        char ch = board[i][j];
        board[i][j] = '0';

        return backtrack(board, i - 1, j, idx + 1) ||
                backtrack(board, i + 1, j, idx + 1) ||
                backtrack(board, i, j + 1, idx + 1) ||
                backtrack(board, i, j - 1, idx + 1) ||
                (board[i][j] = ch) == '0';

    }
}
