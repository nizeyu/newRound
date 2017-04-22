public class Solution
{
    public int searchInsert(int[] nums, int target)
    {
        if(nums == null || nums.length == 0)
            return 0;
        
        int l = 0;
        int r = nums.length - 1;
        
        if(target < nums[0])
            return 0;
        
        if(target > nums[r])
            return r + 1;
        
        while(l <= r)
        {
            int m = l + (r - l) / 2;
            
            if(nums[m] == target)
                return m;
            else if(nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        
        return l;
    }
}
