public class Solution
{
    public int majorityElement(int[] nums)
    {
        int majority = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        
        for(int key: map.keySet())
        {
            if(map.get(key) > nums.length / 2)
                majority = key;
        }
        
        return majority;
    }
}
