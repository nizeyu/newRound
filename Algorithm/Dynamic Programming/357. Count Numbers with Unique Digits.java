//Method 1: DP
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;
        
        int[] dp = new int[n+1];
        int availableNumber = 9;
        dp[0] = 1;
        dp[1] = 9;
        int res = dp[0] + dp[1];
        for(int i = 2; i <= n; ++i) {
            dp[i] = dp[i-1] * availableNumber;
            res += dp[i];
            availableNumber--;
        }
        return res;
    }
}

//Method 2: backtracking
