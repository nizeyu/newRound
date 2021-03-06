//Method 1: O(n^2) DP
public class Solution
{
    public int integerBreak(int n)
    {
        int[] dp = new int[n+1];
        
        for(int i = 1; i < n; i++)
            for(int j = 1; j <= i; j++)
            {
                if(i + j <= n)
                    dp[i + j] = Math.max(Math.max(dp[i], i) * Math.max(dp[j], j), dp[i + j]);
            }
        return dp[n];
    }
}


//Method 2: O(n) DP
public class Solution {
    public int integerBreak(int n)
    {
        if(n <= 3)
            return n - 1;
            
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i < n + 1; i++)
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        
        return dp[n];
    }
}
