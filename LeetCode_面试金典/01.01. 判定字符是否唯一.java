class Solution {
    public boolean isUnique(String astr) {
        int tag = 0;
        char[] chars = astr.toCharArray();
        for (char ch : chars) {
            int idx = ch - 'a';
            if ((1 << idx & tag) != 0) {
                return false;
            }
            tag = tag ^ 1 << idx;
        }
        return true;
    }
}