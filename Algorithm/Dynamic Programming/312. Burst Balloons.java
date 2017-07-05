public class Solution {
    public int maxCoins(int[] nums) {
        int[] iNums = new int[nums.length+2];
        int n = iNums.length;
        for (int i = 0; i < nums.length; i++) {
            iNums[i+1] = nums[i];
        }
        iNums[0] = iNums[n-1] = 1;
        
        int[][] dp = new int[n][n];
        
        for (int i = 2; i < n; i++) {
            for (int L = 0; L < n - i; L++) {
            	int R = L + i;
                for (int M = L + 1; M < R; M++) {
                    dp[L][R] = Math.max(dp[L][R], iNums[L]*iNums[M]*iNums[R] + dp[L][M] + dp[M][R]);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
