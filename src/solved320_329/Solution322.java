package solved320_329;

import java.util.Arrays;

class Solution322 {//零钱兑换

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        //dp[i]表示零钱i兑换所需最少的硬币个数
        Arrays.fill(dp, Integer.MAX_VALUE);

        //初始化
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i < amount + 1; i++) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        //不能兑换则返回-1
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] Dict = {1, 2, 5};
        Solution322 solution = new Solution322();
        System.out.println(solution.coinChange(Dict, 11));
    }
}