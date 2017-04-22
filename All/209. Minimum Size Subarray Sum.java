public class Solution
{
    public int minSubArrayLen(int s, int[] nums)
    {
        if(nums == null && nums.length == 0)
            return -1;
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while(start < nums.length && end < nums.length)
        {
            while(end < nums.length && sum < s)
                sum += nums[end++];
            
            while(start < end && sum >= s)
            {
                min = Math.min(min, end - start);
                sum -= nums[start++];
            }
        }
        
        return min == Integer.MAX_VALUE?0: min;
    }
}
