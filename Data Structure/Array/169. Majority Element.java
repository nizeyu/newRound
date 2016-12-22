//Method 1
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

//Method 2： Boyer–Moore majority vote algorithm
//https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm

public class Solution
{
    public int majorityElement(int[] nums)
    {
        int count = 0;
        int result = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(count == 0)
            {
                result = nums[i];
                count  = 1;
            }
            else if(nums[i] == result)
                count++;
            else
                count--;
        }
        
        return result;
    }
}

//Method 3
public class Solution
{
    public int majorityElement(int[] nums)
    {
        Arrays.sort(nums);

		return nums[nums.length / 2];
    }
}
