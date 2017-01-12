public class Solution
{
    public List<Integer> largestDivisibleSubset(int[] nums)
    {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for(int i = 1; i < nums.length; i++)
            for(int j = i - 1; j >= 0; j--)
            {
                if(nums[i] % nums[j] == 0)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        
        int maxIndex = 0;
        for(int i = 1; i < nums.length; i++)
            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        
        int temp = nums[maxIndex];
        int curDp = dp[maxIndex];
        for(int i = maxIndex; i >= 0; i--)
        {
            if(temp % nums[i] == 0 && dp[i] == curDp)
            {
                res.add(nums[i]);
                temp = nums[i];
                curDp--;
            }
        }
        return res;
    }
}
