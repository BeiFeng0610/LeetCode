class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, max = 0;
        int[][] dp = new int[n][n];
        for(int i = 2 ; i < n ; i++){
            int j = 0, k = i-1;
            while(j < k){
                // 满足这个必定至少存在3个（题目最小长度为3）
                if(arr[j] + arr[k] == arr[i]){
                    // 如果前置没有斐波那契数列，则从3开始记录
                    if(dp[j][k] == 0){
                        dp[k][i] = 3;
                    }else{
                        // 如果有前置，则从k到i，判断那个长，区间为 jk ki,大区间 j i,k为中点
                        dp[k][i] = Math.max(dp[j][k]+1, dp[k][i]);
                    }
                    // 更新最大值
                    max = Math.max(max, dp[k][i]);
                    // 缩小区间
                    j++;k--;
                }
                // 小于则缩小区间[j+1,k]
                else if(arr[j] + arr[k] < arr[i]){
                    j++;
                }else {
                    //大于则[j,k-1]
                    k--;
                }
            }
        }
        return max;
    }
}
