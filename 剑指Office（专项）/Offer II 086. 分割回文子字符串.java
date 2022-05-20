class Solution {
    boolean[][] f;
    List<List<String>> tmp = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;

    public String[][] partition(String s) {
        n = s.length();
        f = new boolean[n][n];

        // 初始化所有的全为true  例如 11 22 33 44
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        // 动态规划，列出所有的回文子串。
        // 例如：google  n=5, 从 56 判断，但是不存在 5 6，继续 45 34 35 23 24 25 12 13 14 15
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 如果判断 13 就要看 22 是否为回文，14 看 23是否为回文
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        // 把集合转为字符串数组
        int rows = tmp.size();
        String[][] ret = new String[rows][];
        for (int i = 0; i < rows; ++i) {
            int cols = tmp.get(i).size();
            ret[i] = new String[cols];
            for (int j = 0; j < cols; ++j) {
                ret[i][j] = tmp.get(i).get(j);
            }
        }
        return ret;
    }

    public void dfs(String s, int i) {
        // 长度满足即返回。
        if (i == n) {
            tmp.add(new ArrayList<>(ans));
        }
        for (int j = i; j < n; j++) {
            // 如果是回文就添加，判断每个下标的 1 -- n-1长度的字符串是否为回文
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
