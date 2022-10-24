class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return helper(countAndSay(n - 1));
    }

    private String helper(String str) {
        int len = str.length();
        int end = 0;
        StringBuilder sb = new StringBuilder();
        while (end < len) {
            int start = end;
            while (end < len) {
                if (str.charAt(start) == str.charAt(end)) {
                    end++;
                } else {
                    break;
                }
            }
            sb.append(end - start).append(str.charAt(start));
        }
        return sb.toString();
    }
}

class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int end = 0;

            while (end < str.length()) {
                while (end < str.length() && str.charAt(end) == str.charAt(start)) {
                    end++;
                }
                sb.append(end - start).append(str.charAt(start));
                start = end;
            }
            str = sb.toString();
        }
        return str;
    }
}

