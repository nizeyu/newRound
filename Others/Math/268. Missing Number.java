//method 1: wrong
public class Solution
{
    public int missingNumber(int[] nums)
    {
        if(nums == null || nums.length == 0)
            throw new IllegalArgumentException();
        
        long zeroIsNegative = Long.MIN_VALUE;
        boolean max = false;
        for(int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]);
            
            if(Math.abs(nums[i]) == nums.length)
                max = true;
            else if(nums[index] == 0) 
                zeroIsNegative = index;
            else
            {
                nums[index] = -nums[index];
            }
        }
        
        if(max == false)
            return nums.length;
        if(zeroIsNegative != Long.MIN_VALUE)
            return (int)zeroIsNegative;
    
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] >= 0)
                return i;
        }
        
        return 0;
    }
}

//method 2:
public class Solution
{
    public int missingNumber(int[] nums)
    {
        if(nums == null || nums.length == 0)
            throw new IllegalArgumentException();
        
        int xor = 0;
        for(int i = 0; i < nums.length; i++)
            xor ^= i ^ nums[i];
        
        return xor ^ nums.length;
    }
}
