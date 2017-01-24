public class Solution
{
    public int getMoneyAmount(int n)
    {
        int[][] dp = new int[n+1][n+1];
        return DP(dp, 1, n);
    }
    
    private int DP(int[][] dp, int L, int R)
    {
        if(L >= R) return 0;
        if(dp[L][R] != 0) return dp[L][R];
        int res = Integer.MAX_VALUE;
        for(int x = L; x <= R; x++)
        {
            int tmp = x + Math.max(DP(dp, L, x - 1), DP(dp, x + 1, R));
            res = Math.min(res, tmp);
        }
        dp[L][R] = res;
        return res;
    }
}
