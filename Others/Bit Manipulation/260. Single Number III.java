public class Solution
{
    public int[] singleNumber(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return new int [0];
        
        int x1XORx2 = 0;
        for(int num: nums)
            x1XORx2 ^= num;
        
        int last1Bit = x1XORx2 - (x1XORx2 & (x1XORx2 - 1));
        
        int single1 = 0;
        int single2 = 0;
        
        for(int x: nums)
        {
            if((x & last1Bit) == 0 )
                single1 ^= x;
            else
                single2 ^= x;
        }
        
        return new int[] {single1, single2};
    }
}
