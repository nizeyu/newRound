//Method 1：超时
public class Solution
{
    public int maxRotateFunction(int[] A)
    {
        if(A == null || A.length == 0)
            return 0;
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++)
        {
            int f = 0;
            for(int j = 0; j < A.length; j++)
                f += ((j + i) % A.length) * A[j];
                
            max = Math.max(max, f);
            
        }
        
        return max;
    }
}

//Method 2: F(k) = F(k-1) + sum - nBk[0]
public class Solution
{
    public int maxRotateFunction(int[] A)
    {
        if(A == null || A.length == 0)
            return 0;
        
        int f = 0;
        int sum = 0;
        
        for(int i = 0; i < A.length; i++)
        {
           f += i * A[i];
           sum += A[i];
        }
        
        int max = f;
        for(int i = A.length - 1; i >= 1; i--)
        {
            f += sum - A.length * A[i];
            max = Math.max(f, max);
        }
        
        return max;
    }
}
