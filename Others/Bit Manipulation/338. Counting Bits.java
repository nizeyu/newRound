//DP
public class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int offset = 1;
        for(int index = 1; index < num + 1; ++index) {
            if(offset * 2 == index)
                offset *= 2;
            
            dp[index] = dp[index - offset] + 1;
        }
        return dp;
    }
}

public class Solution
{
    public int[] countBits(int num)
    {
        if(num < 0)
            return new int[0];
        
        int[] result = new int[num+1];
        
        for(int i = 0; i <= num; i++)
            result[i] = count(i);
        
        return result;
    }
    
    private int count(int x)
    {
        int ones = 0;
        
        while(x > 0)
        {
            if((x & 1) == 1)
                ones++;
            
            x >>= 1;
        }
        
        return ones;
    }
}
