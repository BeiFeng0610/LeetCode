class Solution {
    public int maximalRectangle(String[] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length();
        int[][] left = new int[m][n];
        
        // 初始化每一个坐标左边1的个数，即为当前行，当前下标往左的最大宽度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1] + 1);
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            // 计算每个坐标从下往上转换为直方图最大面积那一题，从下往上看成从左往右。记录最大值即可
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) == '0') {
                    continue;
                }
                int width = left[i][j];
                // 当前下标，当前行左边宽度。记录面积
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
}


class Solution2 {
    public int maximalRectangle(String[] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length();
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int j = 0; j < n; j++) {
            int[] up = new int[m];
            int[] down = new int[m];
            // 填充下边界全为m
            Arrays.fill(down, m);
            
            Deque<Integer> stack = new LinkedList<>();
            // 转成一列一列的直方图，记录最大值
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    down[stack.peek()] = i;
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
}
