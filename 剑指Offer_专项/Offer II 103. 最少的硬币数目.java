class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }
    private int coinChange(int[] coins, int rem, int[] count) {
        // 小于零说明，硬币多了，不符合
        if (rem < 0) {
            return -1;
        }
        // 等于零则返回0
        if (rem == 0) {
            return 0;
        }
        // 如果count最后有值则说明有其他情况
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 遍历所有组合
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        // 更新最小的组合
        count[rem - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return count[rem - 1];
    }
}
