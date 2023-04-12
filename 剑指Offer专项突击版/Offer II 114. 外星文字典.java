class Solution {
    // 设置拓扑排序的查找状态
    static final  int VISITING = 1, VISITED = 2;
    Map<Character, List<Character>> edges = new HashMap<>();
    Map<Character, Integer> states = new HashMap<>();
    boolean valid = true;
    char[] order;
    int index;
    public String alienOrder(String[] words) {
        int len = words.length;
        for (String word : words) {
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = word.charAt(j);
                // 找到所有的结点
                edges.putIfAbsent(c, new ArrayList<>());
            }
        }
        // 找到所有结点的有向边
        for (int i = 1; i < len; i++) {
            addEdge(words[i - 1], words[i]);
        }
        // 模拟排序
        order = new char[edges.size()];
        index = edges.size() - 1;
        Set<Character> letterSet = edges.keySet();
        // 如果没有开始查找就进行dfs
        for (char u : letterSet) {
            if (!states.containsKey(u)) {
                dfs(u);
            }
        }
        if (!valid) {
            return "";
        }
        return new String(order);
    }

    // 查找所有字母的有向边
    public void addEdge(String before, String after) {
        int length1 = before.length(), length2 = after.length();
        int length = Math.min(length1, length2);
        int index = 0;
        while (index < length) {
            char c1 = before.charAt(index), c2 = after.charAt(index);
            if (c1 != c2) {
                edges.get(c1).add(c2);
                break;

            }
            index++;
        }
        if (index == length && length1 > length2) {
            valid = false;
        }
    }

    // 从某个结点开始深度遍历，判断是否有环路。
    public void dfs(char u){
        states.put(u, VISITING);
        List<Character> adjacent = edges.get(u);
        for (char v : adjacent) {
            if (!states.containsKey(v)) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (states.get(v) == VISITING) {
                valid = false;
                return;
            }
        }
        states.put(u, VISITED);
        order[index] = u;
        index--;
    }
}
