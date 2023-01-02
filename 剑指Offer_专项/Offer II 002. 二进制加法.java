class Solution {
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            // 判断越界，没越界就获取没获取过的最后一位，为1就统计加1
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            // 判断是否有上一次进位，carry=3 字符串加1，继续发生进位
            ans.append((char) (carry % 2 + '0'));
            // 如果 carry>2 发生进位
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
}
