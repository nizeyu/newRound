//My Solution: bit manipulate
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1)
            return false;
        return Integer.bitCount(n) == 1;
        
    }
}

//My Solution: while
public class Solution
{
    public boolean isPowerOfTwo(int n)
    {
        if(n <= 0)
            return false;
            
        while(n % 2 == 0)
            n /= 2;
            
        if(n == 1)
            return true;
        else
            return false;
    }
}
