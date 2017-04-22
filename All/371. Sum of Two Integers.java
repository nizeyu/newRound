//My Solution
public class Solution {
    public int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        
        int res = 0;
        int m = 1;// for ones, tens...
        int carry = 0;
        while(a != 0 || b != 0) {
            int x = a % 10;
            int y = b % 10;
            int digit = x + y + carry;
            carry = digit / 10;
            
            res += (digit % 10) * m;
            a /= 10;
            b /= 10;
            m *= 10;
        }
        
        while(a != 0) {
            res += (a + carry) % 10 * m;
            carry = (a + carry) / 10;
            a /= 10;
            m *= 10;
        }
        while(b != 0) {
            res += (b + carry) % 10 * m;
            carry = (b + carry) / 10;
            b /= 10;
            m *= 10;
        }
        if(carry != 0) res += carry * m;
        
        return res;
    }
}

//Method: Iterative
public class Solution {
    public int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        
        return a;
    }
}

//Method: Recursive
public class Solution
{
    public int getSum(int a, int b)
    {
        return b==0? a:getSum(a^b, (a&b)<<1);
    }
}
