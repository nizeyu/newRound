//Method 1: 超时
public class Solution
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        if(nums == null || nums.length < 2 )
             return false;
             
        Map<Integer, Long> map = new HashMap<>();
         
        for(int i = 0; i < nums.length; i++)
        {
            if (i >= k + 1) map.remove(i - k - 1, map.get(i-k-1));
            for(long val : map.values())
            {
                //System.out.println(nums[i] - val);
                if(Math.abs(nums[i] - val) <= t)
                    return true;
            }
                
            map.put(i, (long)nums[i]);
        }
         return false;
    }
}

//Method 2: 有范围 -》bucket sort 
public class Solution
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        if(nums == null || nums.length < 2 || k < 1 || t < 0)
             return false;
             
        Map<Long, Long> map = new HashMap<>();
         
        for(int i = 0; i < nums.length; i++)
        {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if(map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if(map.entrySet().size() >= k)
            {
                long lastBucket = ((long) nums[i-k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
         return false;
    }
}
