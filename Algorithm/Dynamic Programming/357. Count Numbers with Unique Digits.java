//Method 1: DP
public class Solution
{
    public int countNumbersWithUniqueDigits(int n)
    {
        if(n == 0)
            return 1;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        for(int i = 2; i < dp.length; i++)
            dp[i] = dp[i-1] * (9 - i + 2);
        
        int result = dp[dp.length - 1];
        for(int i = 0; i < dp.length - 1; i++)
            result += dp[i];
        
        return result;
    }
}

//Method 2: backtracking
