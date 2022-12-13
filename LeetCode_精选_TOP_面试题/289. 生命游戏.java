class Solution {

    int[][] deviation = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };
    int row;
    int cols;
    boolean[][] modified;

    public void gameOfLife(int[][] board) {
        row = board.length;
        cols = board[0].length;
        modified = new boolean[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                status(board, i, j);
            }
        }
    }

    private void status(int[][] board, int i, int j) {
        int count = 0;
        for (int[] ints : deviation) {
            int newI = i + ints[0];
            int newJ = j + ints[1];
            if (isAlive(board, newI, newJ)) {
                count++;
            }
        }
        if (count == 3) {
            if (board[i][j] == 0) {
                board[i][j] = 1;
                modified[i][j] = true;
            }
        } else if (count != 2) {
            if (board[i][j] == 1) {
                board[i][j] = 0;
                modified[i][j] = true;
            }
        }
    }

    private boolean isAlive(int[][] board, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= cols) {
            return false;
        }
        return (board[i][j] == 1 && !modified[i][j]) || (board[i][j] == 0 && modified[i][j]);
    }
}

class Solution {
    int[] deviation = {0, 1, -1};
    int row;
    int cols;

    public void gameOfLife(int[][] board) {
        row = board.length;
        cols = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                status(board, i, j);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }

    }

    private void status(int[][] board, int i, int j) {
        int count = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!(deviation[r] == 0 && deviation[c] == 0)) {
                    int newI = i + deviation[r];
                    int newJ = j + deviation[c];
                    if (isAlive(board, newI, newJ)) {
                        count++;
                    }
                }
            }
        }
        if (count == 3) {
            if (board[i][j] == 0) {
                board[i][j] = 2;
            }
        } else if (count != 2) {
            if (board[i][j] == 1) {
                board[i][j] = -1;
            }
        }
    }

    private boolean isAlive(int[][] board, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= cols) {
            return false;
        }
        return board[i][j] == 1 || board[i][j] == -1;
    }
}