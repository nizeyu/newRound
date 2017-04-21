public class Solution
{
    public int[] plusOne(int[] digits)
    {
        int c = 0;
        
        for (int i = digits.length - 1; i >= 0; i--)
        {
            if (digits[i] + c + 1 >= 10) 
            {
                digits[i] = 0;
                c = 1;
                continue;
            }
            else
            {
                digits[i] = digits[i] + 1 + c;
                c = 0;
                break;
            }
        }
        
        if (c == 1)
        {
            int [] temp = new int[digits.length + 1];
            temp[0] = 1;
            
            for(int i = 1; i < temp.length; i++)
                temp[i] = digits[i - 1];
                
            return temp;
        }
        
        return digits;
    }
}
