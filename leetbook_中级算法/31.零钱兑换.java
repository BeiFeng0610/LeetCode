import java.util.Arrays;

class Solution {
    int ans;
    int amount;
    public int coinChange(int[] coins, int amount) {
        this.amount = amount;
        ans = Integer.MAX_VALUE;
        dfs(0, 0, coins);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int count, int sum, int[] coins) {
        if (sum == amount) {
            ans = Math.min(ans, count);
        } else {
            for (int i = 0; i < coins.length; i++) {
                int t = coins[i];
                if (t > amount - sum) {
                    break;
                }
                sum += t;
                dfs(count + 1, sum, coins);
                sum -= t;
            }
        }
    }
}

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        /**
         * 当前层次的 rem 最少组成的个数，上一次是求这一层的最少个数，直接返回。
         * 记忆化存储到count数组中，避免多次计算。
         */
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}


