public class Solution
{
    public int coinChange(int[] coins, int amount)
    {
        if(coins == null || coins.length == 0)
            return -1;
        if(amount == 0)
            return 0;
        
        int[] dp = new int[amount+1];
        for(int i = 1; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;
        
        for(int i = 1; i < dp.length; i++)
        {
            for(int coin : coins)
                if(i - coin >= 0 && dp[i-coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i-coin]+1, dp[i]);
        }
        
        if(dp[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return dp[amount];
    }
}
