//My Solution 1
public class Solution {
    public int findComplement(int num) {
        int helper1 = 1;//to indicate the first "1"
        helper1 <<= 30;
        
        while((num & helper1) == 0)
            helper1 >>= 1;
        
        int helper2 = 1;//to flip the bit
        for(int i = 0; i < 31; i++) {
            num ^= helper2;
            System.out.println(Integer.toBinaryString(num));
            if(helper2 < helper1)
                helper2 <<= 1;
            else 
                break;
        }
        return num;
    }
}

//My Solution 2:
public class Solution {
    public int findComplement(int num) {
        int res = 0;
        int i = 0;
        while(num != 0) {
            int temp = num & 1;
            temp ^= 1;
            temp <<= i;
            res |= temp;
            num >>= 1;
            i++;
        }
        return res;
    }
}
