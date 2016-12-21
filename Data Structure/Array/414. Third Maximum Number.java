public class Solution
{
    public int thirdMax(int[] nums)
    {
        long[] max = new long[3];
        for(int i = 0; i < 3; i++)
            max[i] = Long.MIN_VALUE;
        
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > max[2])
            {
                max[0] = max[1];
                max[1] = max[2];
                max[2] = nums[i];
            }
            else if(nums[i] < max[2] && nums[i] > max[1])
            {
                max[0] = max[1];
                max[1] = nums[i];
            }
            else if(nums[i] < max[1] && nums[i] >= max[0])
            {
                max[0] = nums[i];
            }
            else
                continue;
        }
        if( max[0] == Long.MIN_VALUE)
            return (int)max[2];
        
        return (int)max[0];
    }
}
