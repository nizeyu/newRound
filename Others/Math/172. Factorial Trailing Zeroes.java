public class Solution
{
    public int trailingZeroes(int n)
    {
        if(n < 5)
            return 0;
        
        int count_five = 0;
        while(n > 0)
        {
            count_five += n / 5;
            n /= 5;
        }
        
        return count_five;
    }
}
