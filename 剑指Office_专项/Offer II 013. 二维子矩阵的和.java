class NumMatrix {
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        initPre(this.matrix);
    }

    private void initPre(int[][] matrix) {
        // 求出每行前缀和
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                this.matrix[i][j] += this.matrix[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        
        // 根据行列，直接统计前缀之差
        for (int i = row1; i <= row2; i++) {
            if (col1 > 0) {
                sum += matrix[i][col2] - matrix[i][col1 - 1];
            } else {
                sum += matrix[i][col2];
            }
        }
        return sum;
    }
}
