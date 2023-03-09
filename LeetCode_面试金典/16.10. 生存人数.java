class Solution {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] change = new int[102];
        for (int i = 0; i < birth.length; i++) {
            change[birth[i] - 1900]++;
            change[death[i] - 1899]--;
        }

        int cur = 0;
        int max = 0;
        int year = 1900;
        for (int i = 0; i < 101; i++) {
            cur += change[i];
            if (cur > max) {
                max = cur;
                year = 1900 + i;
            }
        }
        return year;
    }
}