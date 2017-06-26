// Brute Force 1: DFS
public class Solution {
    public int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        Arrays.sort(coins);
        backtracking(0, 0, coins, amount);
        
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        
        return min;
    }
    
    private void backtracking(int startIndex, int count, int[] coins, int remainAmount) {
        // get result
        if (remainAmount == 0) {
            min = Math.min(min, count);
            //System.out.println(min);
            return;
        }
        
        // backtracking
        for (int i = startIndex; i < coins.length; i++) {
            if (remainAmount < 0) {
                break;
            }
            
            // System.out.println(remainAmount);
            remainAmount -= coins[i];
            count++;
            backtracking(i, count, coins, remainAmount);
            remainAmount += coins[i];
            count--;
        }
    }
}

// Brute Force 2: DFS
public class Solution {
    public int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        helper(0, 0, coins, amount);
        
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        
        return min;
    }
    
    private void helper(int start, int count, int[] coins, int amount) {
        // get results
        if (amount < 0) {
            return;
        }
        
        if (amount == 0) {
            min = Math.min(min, count);
            return;
        }
        
        // recursive
        if (start < coins.length) {
            for (int i = 0; ; i++) {
                amount -= i * coins[start];
                count += i;
                helper(start+1, count, coins, amount);
                if (amount <= 0) {
                    break;
                }
                count -= i;
                amount += i * coins[start];
            }
        }
    }
}

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
