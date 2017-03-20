public class Solution {
    public int[] singleNumber(int[] nums) {
        int AxorB = 0;
        for(int i = 0; i < nums.length; ++i)
            AxorB ^= nums[i];
        
        // int x = 1;
        // while((AxorB & x) == 0) {
        //     x <<= 1;
        // }
        
        // Get its last set bit
        AxorB &= -AxorB;
        
        int num0 = 0;
        int num1 = 0;
        for(int i = 0; i < nums.length; ++i) {
            if((AxorB & nums[i]) == 0)
                num0 ^= nums[i];
            else
                num1 ^= nums[i];
        }
        
        return new int[] {num0, num1};
    }
}
