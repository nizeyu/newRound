public class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) 
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int key : map.keySet()) {
            if(k == 0) {
                if(map.get(key) >= 2)
                    count++;
            } else {
                if(map.containsKey(key + k))
                    count++;
            }
        }
        return count;
    }
}
