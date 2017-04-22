//My Solution: naive
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = 0;
        for(int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for(int j = i; j < nums.length; ++j) {
                sum += nums[j];
                //System.out.println(sum);
                if(sum == k)
                    max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}

//HashMap
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            
            if(sum == k)
                max = i + 1;
            else if(map.containsKey(sum - k))
                max = Math.max(max, i - map.get(sum - k));
            
            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        return max;
    }
}
