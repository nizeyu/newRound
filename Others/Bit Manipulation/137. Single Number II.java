public class Solution {
    public int singleNumber(int[] nums) {
        
        int res = 0;
        for(int i = 0; i < 32; ++i) {
            int bit = (1 << i);
            int count = 0;
            for(int j = 0; j < nums.length; ++j) {
                if((nums[j] & bit) != 0)
                    count++;
            }
            //res |= (count % 3 << i);
            
            if(count % 3 != 0)
                res |= bit;
        }
        
        return res;
    }
}
