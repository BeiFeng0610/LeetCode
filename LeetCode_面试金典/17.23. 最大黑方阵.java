class Solution {
    public int[] findSquare(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        if (matrix.length == 1) {
            if (matrix[0][0] == 0) {
                return new int[]{0, 0, 1};
            } else {
                return new int[0];
            }
        }

        int[] res = new int[3];
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            if (len - i < res[2]) {
                break;
            }
            for (int j = 0; j < len; j++) {
                if (len - j < res[2]) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    int l = square(i, j, matrix);
                    if (res[2] < l) {
                        res[0] = i;
                        res[1] = j;
                        res[2] = l;
                    }
                }
            }
        }
        if (res[2] == 0) {
            return new int[0];
        }
        return res;
    }

    private int square(int x, int y, int[][] matrix) {
        int l = 1;
        int res = 1;
        while (x + l < matrix.length && y + l < matrix.length) {
            boolean flag = false;
            if (matrix[x][y + l] == 1) {
                break;
            }
            if (matrix[x + l][y] == 1) {
                break;
            }
            for (int i = y + 1; i <= y + l; i++) {
                if (matrix[x + l][i] == 1) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int i = x + 1; i <= x + l; i++) {
                    if (matrix[i][y + l] == 1) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                res = l + 1;
            }
            l++;
        }
        return res;
    }
}
