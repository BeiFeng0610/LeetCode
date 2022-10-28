import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new LinkedList<>();
        }
        int l = 0, r = matrix[0].length - 1;
        int t = 0, b = matrix.length - 1;
        List<Integer> list = new ArrayList<>();
        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) {
                list.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i <= b; i++) {
                list.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l && t <= b; i--) {
                list.add(matrix[b][i]);
            }
            b--;
            for (int i = b; i >= t && l <= r; i--) {
                list.add(matrix[i][l]);
            }
            l++;
        }
        return list;
    }
}