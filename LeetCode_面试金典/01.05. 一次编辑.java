class Solution {
    public boolean oneEditAway(String first, String second) {
        int n = first.length(), m = second.length();
        if (Math.abs(n - m) > 1) {
            return false;
        }
        if (n > m) {
            return oneEditAway(second, first);
        }
        int i = 0, j = 0, count = 0;
        while (i < n && j < m && count <= 1) {
            char c1 = first.charAt(i);
            char c2 = second.charAt(j);
            if (c1 != c2) {
                if (n == m) {
                    i++;
                }
                j++;
                count++;
            } else {
                i++;
                j++;
            }

        }
        return count <= 1;
    }
}