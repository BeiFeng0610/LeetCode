class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int one = 0, zero = 0;
        for(char c : s.toCharArray()){
            if(c == '0') {
                // 如果为0，并且前面有1，就抵消一个，抵消完毕后，就不继续加入
                // 例如：1100，抵消两个，记录2
                // 11000，只需要抵消两个，记录2
                // 110，抵消一个，记录1
                // 01101000，总共抵消三个，记录3
                // 0100110011000，总共抵消5个
                one = Math.min(zero, one) + 1;
            } else if(c == '1'){
                one = Math.min(zero, one);
                zero++;
            }
        }
        return Math.min(one, zero);
    }
}
