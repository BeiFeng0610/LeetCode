class Solution {
    private int row;
    private int cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) {
            return image;
        }
        row = image.length;
        cols = image[0].length;
        if (image[sr][sc] == newColor) {
            return image;
        }
        bfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void bfs(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || i >= row || j < 0 || j >= cols || image[i][j] != oldColor) {
            return;
        }
        image[i][j] = newColor;
        bfs(image, i + 1, j, oldColor, newColor);
        bfs(image, i - 1, j, oldColor, newColor);
        bfs(image, i, j + 1, oldColor, newColor);
        bfs(image, i, j - 1, oldColor, newColor);
    }
}