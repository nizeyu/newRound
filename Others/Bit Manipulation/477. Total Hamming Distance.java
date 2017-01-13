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
