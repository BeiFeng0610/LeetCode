class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s3 = s2 + s2;
        return s3.contains(s1);
    }
}

class Solution {
    public boolean isFlipedString(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        if (len1 == 0) {
            return true;
        }
        for (int i = 0; i < len2; i++) {
            boolean flag = false;
            if (s1.charAt(0) == s2.charAt(i)) {
                for (int j = 0; j < len1; j++) {
                    if (s1.charAt(j) != s2.charAt((i + j) % len2)) {
                        break;
                    }
                    if (j == len1 - 1) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean isFlipedString(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        if (len1 == 0) {
            return true;
        }
        for (int i = 0; i < len2; i++) {
            char ch = s2.charAt(i);
            if (s1.charAt(0) == ch) {
                String s3 = s2.substring(i, len2) + s2.substring(0, i);
                if (s3.equals(s1)) {
                    return true;
                }
            }
        }
        return false;
    }
}