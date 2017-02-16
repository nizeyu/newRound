//My Solution
public class Solution {
    public int findComplement(int num) {
        int helper1 = 1;//to indicate the first "1"
        
        for(int i = 0; i < 30; i++) {
            helper1 <<= 1;
        }
        while((num & helper1) == 0 && helper1 >= 0)
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
