//My Solution
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)
            return new int[0];
    
        int carry = 0;
        int digit = digits[digits.length - 1] + 1;
        if(digit == 10) {
            digits[digits.length - 1] = 0;
            carry = 1;
        } else {
            digits[digits.length - 1] = digit;
            return digits;
        }
        
        for(int i = digits.length - 2; i >= 0; i--) {
            if(digits[i] + 1 < 10) {
                digits[i] += 1;
                carry = 0;
                return digits;
            } else {
                carry = 1;
                digits[i] = 0;
            }
        }
        
        if(carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}

//简化版
public class Solution
{
    public int[] plusOne(int[] digits)
    {
        for (int i = digits.length - 1; i >= 0; i--)
        {
            if (digits[i] < 9) 
            {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int [] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        
        return newDigits;
    }
}
