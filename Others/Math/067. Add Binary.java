public class Solution
{
    public String addBinary(String a, String b)
    {
        if(a == null || a.length() == 0)
            return b;
        if(b == null || b.length() == 0)
            return a;
        
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        
        for(int i = 0; i < a.length(); i++)
            stackA.push(a.charAt(i));
        for(int i = 0; i < b.length(); i++)
            stackB.push(b.charAt(i));
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(!stackA.isEmpty() || !stackB.isEmpty())
        {
            int x = !stackA.isEmpty() ? Character.getNumericValue(stackA.pop()) : 0;
            int y = !stackB.isEmpty() ? Character.getNumericValue(stackB.pop()) : 0;
            
            int digit = x + y + carry;
            
            carry = digit / 2;
            
            sb.insert(0, Integer.toString(digit % 2));
        }
        
        while(!stackA.isEmpty())
        {
            int temp = Character.getNumericValue(stackA.pop()) + carry;
            carry = temp / 2;
            sb.insert(0, Integer.toString(temp % 2));
        }
        
        while(!stackA.isEmpty())
        {
            int temp = Character.getNumericValue(stackB.pop()) + carry;
            carry = temp / 2;
            sb.insert(0, Integer.toString(temp % 2));
        }
        
        if(carry == 1)
             sb.insert(0, '1');
        
        return sb.toString();
    }
}
