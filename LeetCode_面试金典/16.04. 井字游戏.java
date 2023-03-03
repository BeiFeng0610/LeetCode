class Solution {
    public String tictactoe(String[] board) {
        boolean b = false;
        int n = board.length;
        char[][] boards = new char[n][n];
        for (int i = 0; i < n; i++) {
            boards[i] = board[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            int rowX = 0, colX = 0, rowO = 0, colO = 0;
            for (int j = 0; j < n; j++) {
                if (boards[i][j] == ' ') {
                    b = true;
                }
                if (boards[i][j] == 'X') {
                    rowX++;
                } else if (boards[i][j] == 'O') {
                    rowO++;
                }

                if (boards[j][i] == 'X') {
                    colX++;
                } else if (boards[j][i] == 'O') {
                    colO++;
                }

            }
            if (rowX == n || colX == n) {
                return "X";
            }
            if (rowO == n || colO == n) {
                return "O";
            }
        }
        int leftTopX = 0, leftTopO = 0, leftBottomX = 0, leftBottomO = 0;
        for (int i = 0; i < n; i++) {
            if (boards[i][i] == 'X') {
                leftTopX++;
            } else if (boards[i][i] == 'O') {
                leftTopO++;
            }

            if (boards[n - 1 - i][i] == 'X') {
                leftBottomX++;
            } else if (boards[n - 1 - i][i] == 'O') {
                leftBottomO++;
            }
        }
        if (leftTopX == n || leftBottomX == n) {
            return "X";
        }
        if (leftTopO == n || leftBottomO == n) {
            return "O";
        }

        return b ? "Pending" : "Draw";
    }
}