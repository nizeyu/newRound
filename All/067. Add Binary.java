//My Solution
public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int digit = x + y + carry;
            carry = digit / 2;
            
            sb.insert(0, digit % 2);
            i--;
            j--;
        }
        
        if(carry != 0)
            sb.insert(0, carry);
        
        return sb.toString();
    }
}
