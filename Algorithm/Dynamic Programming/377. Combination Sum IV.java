//求出[1, target]之间每个位置有多少种排列方式, 这样将问题分化为子问题
public class Solution
{
    public int combinationSum4(int[] nums, int target)
    {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++)
        {
            for(int num : nums)
                if(i - num >= 0)
                    dp[i] += dp[i-num];
        }
        return dp[target];
    }
}
