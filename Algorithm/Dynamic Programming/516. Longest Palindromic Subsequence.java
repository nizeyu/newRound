public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        
        int[][] dp = new int[len][len];
        
        // i, j相等， 赋初值
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        
        // i, j相差1，赋初值
        for (int i = 0; i < len - 1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1) ? 2 : 1;
        }
        
        // 按斜对角线一条一条往右上，根据递推公式赋值
        for (int m = 2; m < len; m++) {
            for (int n = 0; n < len - m; n++) {
                //dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i+1][j-1]+2 : Math.max(dp[i][j-1], dp[i+1][j]);
                dp[n][n+m] = s.charAt(n) == s.charAt(n+m) ? dp[n+1][n+m-1]+2 : Math.max(dp[n][n+m-1], dp[n+1][n+m]);
            }
        }
        
        return dp[0][len-1];
    }
}
