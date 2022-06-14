package 剑指Office;

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int hang = matrix.length;
        int x = 0, y = hang - 1;
        while (y >= 0 && x < matrix[0].length) {
            if (matrix[y][x] < target) {
                x++;
            } else if (matrix[y][x] > target) {
                y--;
            } else {

                return true;
            }
        }
        return false;
    }
}
