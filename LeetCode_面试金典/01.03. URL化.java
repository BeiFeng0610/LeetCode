class Solution {
    public String replaceSpaces(String s, int length) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String replaceSpaces(String s, int length) {
        char[] chars = s.toCharArray();
        int idx = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[idx--] = '0';
                chars[idx--] = '2';
                chars[idx--] = '%';
            } else {
                chars[idx--] = chars[i];
            }
        }
        return new String(chars, idx + 1, chars.length - idx - 1);
    }
}