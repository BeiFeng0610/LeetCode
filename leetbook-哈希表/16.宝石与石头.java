class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (Character c : jewels.toCharArray()) {
            set.add(c);
        }
        int ret = 0;
        // 这个没啥可说的
        for (Character c : stones.toCharArray()) {
            if (set.contains(c)) {
                ret++;
            }
        }
        return ret;
    }
}
