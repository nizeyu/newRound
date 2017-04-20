//Time: O(n) Space: O(1)
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = 0;
        int zero = 0;
        int k = 1;//flip at most k zero
        
        for(int l = 0, r = 0; r < nums.length; ++r) {
            if(nums[r] == 0) 
                zero++;
                
            while(zero > k) {
                if(nums[l] == 0)
                    zero--;
                l++;
            }
            
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}

//follow up； Time: O(n) Space: O(n)
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = 0;
        int k = 1;//flip at most k zero
        Queue<Integer> zeroIndex = new LinkedList<>();
        for(int l = 0, r = 0; r < nums.length; ++r) {
            if(nums[r] == 0) 
                zeroIndex.offer(r);
                
            if(zeroIndex.size() > k) {
                l = zeroIndex.poll() + 1;
            }
            
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
