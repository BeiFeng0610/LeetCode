class Solution {
    boolean[] tag;
    int cityCount;
    public int findCircleNum(int[][] isConnected) {
        cityCount = isConnected.length;
        tag = new boolean[cityCount];
        int ret = 0;
        for (int i = 0; i < cityCount; i++) {
            if (!tag[i]) {
                ret++;
                dfs(isConnected, i);
            }
        }
        return ret;
    }

    public void dfs(int[][] isConnected, int city) {
        tag[city] = true;
        for (int i = 0; i < cityCount; i++) {
            if (i != city && isConnected[city][i] == 1 && !tag[i]) {
                dfs(isConnected, i);
            }
        }
    }
}
