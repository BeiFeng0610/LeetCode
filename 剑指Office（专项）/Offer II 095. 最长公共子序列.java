class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] cs1 = text1.toCharArray();
        char[] cs2 = text2.toCharArray();
        int[] dp = new int[cs2.length+1];
        for(int i = 1;i<=cs1.length;i++){
            int pre=0;
            for(int j =1;j<=cs2.length;j++){
                // cur表示（i，j）下一次循环就变成（i-1，j-1）了
                int cur = dp[j];
                // i-1,j-1 表示字符串从0开始，但是dp从1开始
                if(cs1[i-1]==cs2[j-1]){
                    dp[j]=pre+1;
                }else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
                //pre 表示（i-1，j-1）
                pre =cur;
            }
        }
        return dp[cs2.length];
    }
}
