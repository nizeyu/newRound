//My Solution
public class Solution {
    public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int res = 0;
        for(int i = 0; i < 31; ++i) {
            int mask = 1 << i;
            
            int count = 0;
            for(int j = 0; j < nums.length; ++j) {
                if((mask & nums[j]) != 0) {
                    count++;
                }
            }
            res += count * (nums.length - count);
        }
        return res;
    }
}

Method 1
public class Solution
{
    public int totalHammingDistance(int[] nums)
    {
        int result = 0;
        for(int i = 0; i < 32; i++)
        {
            int bitCount = 0;
            for(int j = 0; j < nums.length; j++)
            {
                bitCount += Integer.bitCount((nums[j] >> i) & 1);
            }
            result += bitCount * (nums.length - bitCount);
        }
        return result;
    }
}

Mehtod 2: Time Limit Exceeded
public class Solution
{
    public int totalHammingDistance(int[] nums)
    {
        int result = 0;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                result += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return result;
    }
}
