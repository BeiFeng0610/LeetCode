package 剑指Offer第2版;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int hang = matrix.length - 1;
        int lie = matrix[0].length - 1;
        int[] res = new int[(hang + 1) * (lie + 1)];
        int idx = 0, h = 0, l = 0;
        while (true) {
            for (int i = l; i <= lie; i++) {
                res[idx++] = matrix[h][i];
            }
            if (++h > hang) break;
            for (int i = h; i <= hang; i++) {
                res[idx++] = matrix[i][lie];
            }
            if (--lie < l) break;
            for (int i = lie; i >= l; i--) {
                res[idx++] = matrix[hang][i];
            }
            if (--hang < h)break;
            for (int i = hang; i >= h ; i--) {
                res[idx++] = matrix[i][l];
            }
            if (++l > lie) break;
        }

        return res;
    }
}
