class Solution {
    public int singleNumber(int[] nums) {
        int tag = 0;
        for(int i : nums){
            tag ^= i;
        }
        return tag;
    }
}
