class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target < letters[0] || target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int len = letters.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (letters[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return letters[l];
    }
}