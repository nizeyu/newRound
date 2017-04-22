//My Solution
public class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        if(x == 1)
            return 1;
        
        long sqrt = lowerBound(0, x/2, x);
        
        if(sqrt * sqrt > x)
            return (int)(sqrt - 1);
        
        return (int)sqrt;
    }
    
    private long lowerBound(long l, long r, long target) {
        while(l < r) {
            
            long mid = l + (r - l) / 2;
            
            if(target <= mid * mid)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}


//integer Newton
//https://en.wikipedia.org/wiki/Integer_square_root
public class Solution
{
    public int mySqrt(int x)
    {
        if(x < 0)
            throw new IllegalArgumentException();
        
        long r = x;
        while(r * r > x)
            r = (r + x / r) / 2;
        
        return (int)r;
    }
}
