//My Solution
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
        } 
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                res.add(i+1);
        }
        
        return res;
    }
}

//Method 1
public class Solution
{
    public List<Integer> findDisappearedNumbers(int[] nums)
    {
        List<Integer> result = new ArrayList<Integer>();
  
        for(int i = 0; i < nums.length; i++)
        {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] >= 0)
                nums[val] = -nums[val];
        }
        
        for(int i = 0; i < nums.length; i++)
            if(nums[i] > 0)
                result.add(i+1);
        
        return result;
    }
}


//Mehod 2: too slow
public class Solution
{
    public List<Integer> findDisappearedNumbers(int[] nums)
    {
        List<Integer> result = new ArrayList<Integer>();
        
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums)
            set.add(x);
  
        for(int i = 1; i <= nums.length; i++)
        {
            if(!set.contains(i))
                result.add(i);
        }
        
        return result;
    }
}
