//method1: wrong
public class Solution
{
    public int nthUglyNumber(int n)
    {
        if(n < 0)
            throw new IllegalArgumentException();
        if(n == 1)
            return 1;
        
        int[] ugly = new int[3];
        ugly[0] = 1;
        ugly[1] = 1;
        ugly[2] = 1;
        
        int count = 1;
        int u = 1;
        while(count < n)
        {
            u = getUgly(ugly);
            count++;
        }
        
        return u;
    }
    
    public int getUgly(int[] ugly)
    {
        int a = ugly[0] * 2;
        int b = ugly[1] * 3;
        int c = ugly[2] * 5;
        int min = Integer.MAX_VALUE;
        
        if(a < b && a < c)
        {
            min = a;
            ugly[0] = a;
        }
        else if(b < a && b < c)
        {
            min = b;
            ugly[1] = b;
        }
        else
        {
            min = c;
            ugly[2] = c;
        }
        System.out.println(min);
        
        return min;
    }
}

//method 2
public class Solution
{
    public int nthUglyNumber(int n)
    {
        if(n < 0)
            throw new IllegalArgumentException();
        if(n == 1)
            return 1;
        
         int[] ugly = new int[n];
         ugly[0] = 1;
         
         int index2 = 0, index3 = 0, index5 = 0;
         int factor2 = Integer.MAX_VALUE, factor3 = Integer.MAX_VALUE, factor5 = Integer.MAX_VALUE;
         int min = Integer.MAX_VALUE;
         
         for(int i = 1; i < ugly.length; i++)
         {
             factor2 = ugly[index2] * 2;
             factor3 = ugly[index3] * 3;
             factor5 = ugly[index5] * 5;
             min = Math.min(Math.min(factor2, factor3), factor5);
             ugly[i] = min;
             
             if(min == factor2)
                index2++;
             if(min == factor3)
                index3++;
             if(min == factor5)
                index5++;
         }
         
         return ugly[n - 1];
    }
}z
