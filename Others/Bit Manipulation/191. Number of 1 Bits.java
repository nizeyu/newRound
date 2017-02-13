public class Solution
{
    // you need to treat n as an unsigned value
    public int hammingWeight(int n)
    {
        int count = 0;
        
        for(int i = 0; i < 32; i++)
            if(getOne(n, i))
                count++;
        
        return count;
    }
    
    private boolean getOne(int n, int i)
    {
        return (n & (1 << i)) != 0;
    }
}
