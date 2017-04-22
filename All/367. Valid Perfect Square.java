//Binary Search
public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        
        long l = 1;
        long r = num / 2;
        long nums = (long)num;
        while(l <= r) {
            long mid = l + (r - l) / 2;
            long sqrt = mid * mid;
            
            if(sqrt == nums) {
                return true;
            } else if(sqrt < nums) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}

//Math
public class Solution
{
    public boolean isPerfectSquare(int num)
    {
        long r = num;
        
        while(r * r > num)
            r = (r + num / r) / 2;
        
        if(r * r == num)
            return true;
        return false;
    }
}
