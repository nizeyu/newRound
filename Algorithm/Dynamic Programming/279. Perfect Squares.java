public class Solution {
    public int numSquares(int n) {
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int j = 1; j < dp.length; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i * i <= n; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (j + i * i >= dp.length) {
                    break;
                }
                dp[j + i * i] = Math.min(dp[j + i * i], 1 + dp[j]);
            }
            
        }
        
        return dp[n];
    }
}
