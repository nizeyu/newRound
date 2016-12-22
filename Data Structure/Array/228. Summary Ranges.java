public class Solution
{
    public List<String> summaryRanges(int[] nums)
    {
        List<String> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(i+1 == nums.length || nums[i+1] != nums[i] + 1)
            {
                if(start == end)
                    result.add(Integer.toString(nums[start]));
                else
                    result.add(nums[start]+"->"+nums[end]);
                
                start = i + 1;
                end = i + 1;
            }
            else
            {
                end = i + 1;
            }
        }
        
        return result;
    }
}
