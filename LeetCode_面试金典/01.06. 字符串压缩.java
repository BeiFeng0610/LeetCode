class Solution {
    public String compressString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        char cur = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                count++;
            } else {
                sb.append(cur).append(count);
                cur = chars[i];
                count = 1;
            }
        }
        sb.append(cur).append(count);
        return sb.length() < s.length() ? sb.toString() : s;
    }
}

class Solution {
    public String compressString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, len = s.length();
        while (j < len) {
            while (j < len && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            sb.append(s.charAt(i)).append(j - i);
            i = j;
        }
        return sb.length() < s.length() ? sb.toString() : s;
    }
}