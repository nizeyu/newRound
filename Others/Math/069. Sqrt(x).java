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
