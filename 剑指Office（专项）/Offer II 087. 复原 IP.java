class Solution {
    // IP 最多有四部分组成
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];
    
    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s,int segId,int segStart) {
        // 字段满足4
        if (segId == SEG_COUNT) {
            // 起始等于长度表示全部添加了，否则返回，不满足
            if (segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }
        // 如果起始 等于 字符串长度，就返回
        if (segStart == s.length()) {
            return;
        }
        // 前导0，这数字段只能为0，不能0+数字
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            // 累加 判断 addr 大于0 且小于等于 255，然后添加
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new 剑指Office.Solution().restoreIpAddresses("25525511135");
    }
}
