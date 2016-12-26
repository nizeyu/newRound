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
