public class Solution
{
    public int nthSuperUglyNumber(int n, int[] primes)
    {
        if(n < 0)
            throw new IllegalArgumentException();
        if(n == 1)
            return 1;
        
        int[] ugly = new int[n];
        ugly[0] = 1;
        
        int[] factor = new int[primes.length];
        for(int i = 0; i < factor.length; i++)
            factor[i] = Integer.MAX_VALUE;
        
        int[] index = new int[primes.length];
        for(int i = 0; i < index.length; i++)
            index[i] = 0;
        
        for(int i = 1; i < ugly.length; i++)
        {
            int min = Integer.MAX_VALUE;// pay attention to scope of variable
            for(int j = 0; j < factor.length; j++)
            {
                factor[j] = ugly[index[j]] * primes[j];
                min = Math.min(min, factor[j]);
            }
            ugly[i] = min;
            
            for(int k = 0; k < factor.length; k++)
            {
                if(min == factor[k])
                    index[k]++;
            }
        }
        
        return ugly[n - 1];
    }
}
