public class Solution
{
    private static final int base = 1337;
    int powmod(int a, int k) //a^k mod 1337 where 0 <= k <= 10
    {
        int result = 1;
        while(k != 0)
        {
            if(k % 2 != 0)
                result = result * a % base;
            a = a * a % base;
            k /= 2;
        }
        return result;
    }
    public int superPow(int a, int[] b)
    {
        a %= base;
        int result = 1;
        for(int i = b.length - 1; i >= 0; i--)
        {
            result = result * powmod(a, b[i]) % base;
            a = powmod(a, 10);
        }
        return result;
    }
}
