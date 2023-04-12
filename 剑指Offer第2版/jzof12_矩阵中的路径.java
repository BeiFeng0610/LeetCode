package 剑指Offer第2版;

class Solution {
    public static boolean exist(char[][] board, String word) {
        int hang = board.length,lie = board[0].length;
        boolean[][] tag = new boolean[hang][lie];
        boolean flag = false;
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag = dfs(board, word, 0, i, j, tag);
                    if (flag) return true;
                }
            }
        }
        return flag;
    }

    public static boolean dfs(char[][] board, String word, int count, int hang, int lie, boolean[][] tag) {
        if (hang >= board.length || hang < 0 || lie >= board[0].length || lie < 0 || tag[hang][lie] || board[hang][lie] != word.charAt(count)) {
            return false;
        }
        tag[hang][lie] = true;
        if (count == word.length()-1) {
            return true;
        }
        boolean flag = dfs(board, word, count + 1, hang - 1, lie, tag) ||
                dfs(board, word, count + 1, hang, lie + 1, tag) ||
                dfs(board, word, count + 1, hang + 1, lie, tag) ||
                dfs(board, word, count + 1, hang, lie - 1, tag);
        tag[hang][lie] = false;
        return flag;
    }
}
