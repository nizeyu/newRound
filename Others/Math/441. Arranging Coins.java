//Math
public class Solution {
    public int arrangeCoins(int n) {
        double N = n;
        return (int)Math.floor(-0.5 + 0.5 * Math.sqrt(1.0 + 8.0 * N));
    }
}


public class Solution
{
    public int arrangeCoins(int n)
    {
        if(n < 1)
            return 0;
        
        int i = 1;
        int result = 1;
        while(n > 0)
        {
            if(n - i >= 0)
                result = i;
            n -= i;
            i++;
        }
        
        return result;
    }
}
