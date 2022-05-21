class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, max = 0;
        int[][] dp = new int[n][n];
        for(int i = 2 ; i < n ; i++){
            int j = 0, k = i-1;
            while(j < k){
                if(arr[j] + arr[k] == arr[i]){
                    if(dp[j][k] == 0){
                        dp[k][i] = 3;
                    }else{
                        dp[k][i] = Math.max(dp[j][k]+1, dp[k][i]);
                    }
                    max = Math.max(max, dp[k][i]);
                    j++;k--;
                }
                else if(arr[j] + arr[k] < arr[i]){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return max;
    }
}
