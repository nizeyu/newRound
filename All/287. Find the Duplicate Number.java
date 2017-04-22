//Method 1:
public class Solution
{
    public int findDuplicate(int[] nums)
    {
        int n = nums.length;
        int slow = n;
        int fast = n;
        do
        {
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }while(slow != fast);
        slow = n;
        while(slow != fast)
        {
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }
}

//Method 2:
public class Solution
{
    public int findDuplicate(int[] nums)
    {
        if(nums == null || nums.length == 0)
            throw new IllegalArgumentException("Input is invalid");
        
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r)
        {
            int m = l + (r - l) / 2;
            int count = 0;
            
            for(int i = 0; i < nums.length; i++)
            {
                if(nums[i] <= m)
                    count++;
            }
            
            if(count > m)
                r = m - 1;
            else
                l = m + 1;
        }
        return l;
    }
}
