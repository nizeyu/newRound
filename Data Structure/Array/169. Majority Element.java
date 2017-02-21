//Method 1
//too slow
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > nums.length / 2)
                return num;
        }
        return -1;
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
