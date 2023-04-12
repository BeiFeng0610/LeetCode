package 剑指Offer第2版;

class Solution {
    public int maxValue(int[][] grid) {
        int hang = grid.length;
        int lie = grid[0].length;
        int[][] li = new int[hang][lie];
        li[0][0] = grid[0][0];
        for (int i = 1; i < lie; i++) {
            li[0][i] = li[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < hang; i++) {
            li[i][0] = li[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < hang; i++) {
            for (int j = 1; j < lie; j++) {
                li[i][j] = Math.max(li[i - 1][j], li[i][j - 1]) + grid[i][j];
            }
        }

        return li[hang - 1][lie - 1];
    }
}
