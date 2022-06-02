class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int cnt = 0;
        boolean[] vis = new boolean[n];
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(strs[i], new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    map.get(strs[i]).add(strs[j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(strs, vis, i, map);
                cnt++;
            }
        }
        return cnt;
    }

    private void bfs(String[] strs, boolean[] vis, int i, Map<String, List<String>> map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        vis[i] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int j = 0; j < strs.length; j++) {
                if (!vis[j] && map.get(strs[node]).contains(strs[j])) {
                    queue.offer(j);
                    vis[j] = true;
                }
            }
        }
    }

    public boolean isSimilar(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        return cnt <= 2;
    }
}


class Solution2 {
    int[] f;
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int fi = find(i), fj = find(j);
                if (fi == fj) {
                    continue;
                }
                if (check(strs[i], strs[j], m)) {
                    f[fi] = fj;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] == i) {
                ret++;
            }
        }
        return ret;
    }

    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }

    public boolean check(String a, String b, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
