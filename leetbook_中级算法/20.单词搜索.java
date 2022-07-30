class Solution {
    char[][] board;
    char[] words;
    int width, height;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        words = word.toCharArray();
        width = board[0].length;
        height = board.length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (process(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean process(int i, int j, int index) {
        if (index == words.length) {
            return true;
        }
        if (i < 0 || i >= height || j < 0 || j >= width || board[i][j] != words[index]) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '0';
        return process(i + 1, j, index + 1) ||
                process(i - 1, j, index + 1) ||
                process(i, j + 1, index + 1) ||
                process(i, j - 1, index + 1) ||
                (board[i][j] = tmp) == '0';
    }
}


class Solution {
    char[] words;

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        this.words = word.toCharArray();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (check(board, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k]) {
            return false;
        } else if (k == words.length - 1) {
            return true;
        }
        char tmp = words[k];
        board[i][j] = '0';
        return check(board, i + 1, j, k + 1) ||
                check(board, i - 1, j, k + 1) ||
                check(board, i, j + 1, k + 1) ||
                check(board, i, j - 1, k + 1) ||
                (board[i][j] = tmp) == '0';
    }
}
















