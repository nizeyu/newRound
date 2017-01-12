//问题等价为： m x + n y = z是否有关于m、n的整数解。
//上述问题即是裴蜀定理, 即是说，只要z是x、y的最大公约数的倍数即可。
//https://zh.wikipedia.org/wiki/%E8%B2%9D%E7%A5%96%E7%AD%89%E5%BC%8F
public class Solution
{
    public boolean canMeasureWater(int x, int y, int z)
    {
        return x + y == z || (x + y > z) && z % gcd(x, y) == 0;
    }
    
    private int gcd(int a, int b)
    {
        if(a > b)
        {
            int temp = a;
            a = b;
            b = temp;
        }
        while(b != 0)
        {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
