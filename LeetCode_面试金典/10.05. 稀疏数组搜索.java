class Solution {
    public int findString(String[] words, String s) {
        if (s.length() == 0) {
            return 0;
        }
        int len = words.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            while (l <= r && words[l].length() == 0) {
                l++;
            }
            while (l <= r && words[r].length() == 0) {
                r--;
            }
            int mid = l + (r - l) / 2;
            while (mid < r && words[mid].length() == 0) {
                mid++;
            }
            if (s.equals(words[mid])) {
                return mid;
            } else if (words[mid].compareTo(s) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}