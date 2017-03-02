//My Solution
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

//My Solution
public class Solution
{
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        if(nums == null || nums.length < 2 )
            return false;
            
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
                min = Math.min(min, i - map.get(nums[i]));
            
            map.put(nums[i], i);
        }
        
        if(min > k)
            return false;
        else
            return true;
    }
}
