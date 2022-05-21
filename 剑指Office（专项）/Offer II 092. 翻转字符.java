class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int one = 0, zero = 0;
        for(char c : s.toCharArray()){
            if(c == '0') {
                one = Math.min(zero, one) + 1;
            } else if(c == '1'){
                one = Math.min(zero, one);
                zero++;
            }
        }
        return Math.min(one, zero);
    }
}
