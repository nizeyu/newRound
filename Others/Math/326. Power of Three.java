public class Solution
{
    public boolean isPowerOfThree(int n)
    {
        if(n < 1)
            return false;
        
        int maxPower = (int)Math.pow(3, (int)(Math.log(Integer.MAX_VALUE)/Math.log(3)));
        
        return maxPower % n == 0;
    }
}
