class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        // G[1] 代表长度为1的序列种数，
        // 只需让各个 序列数 当作根，即可统计整个序列的种数。
        // 例如 长度为3 1当作根，左子树为空，右子树个数为两个，前面已经计算过长度为2的种数。然后两边做笛卡尔积即可。
        // 接下来就是 2 当作根， 3当作根。
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}