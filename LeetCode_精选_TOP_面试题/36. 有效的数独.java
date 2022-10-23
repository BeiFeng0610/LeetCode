class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][][] subboxes = new boolean[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int idx = c - '0' - 1;
                    if (rows[i][idx] || columns[j][idx] || subboxes[i / 3][j / 3][idx]) {
                        return false;
                    }
                    rows[i][idx] = true;
                    columns[j][idx] = true;
                    subboxes[i / 3][j / 3][idx] = true;
                }
            }
        }
        return true;
    }
}