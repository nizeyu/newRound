//method 1
public class Solution
{
    public void sortColors(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return;
        
        int zero = 0, second = nums.length-1;
        
        for(int i = 0; i <= second; i++)
        {
            while(nums[i] == 2 && i < second)
            {
                swap(nums, i, second);
                second--;
            }
            while(nums[i] == 0 && i > zero)
            {
                swap(nums, i, zero);
                zero++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j)
    {
        if(i < 0 || j < 0 || i > nums.length-1 || j > nums.length-1)
            return;
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//method 2
public class Solution
{
    public void sortColors(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return;
        
        int zero = 0, first = 0, second = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
                zero++;
            else if(nums[i] == 1)
                first++;
            else
                second++;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(i < zero)
                nums[i] = 0;
            else if(i >= zero && i < zero + first)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
}
