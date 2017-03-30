//My Solution: 3刷
public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;
        
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0 || carry == 1) {
            int x = i >= 0 ? Character.getNumericValue(num1.charAt(i)) : 0;
            int y = j >= 0 ? Character.getNumericValue(num2.charAt(j)) : 0;
            int digit = x + y + carry;
            carry = digit / 10;
            
            sb.insert(0, digit % 10);
            i--;
            j--;
        }
        
        return sb.toString();
    }
}

//My Solution: 2刷
public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;
        
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int x = i >= 0 ? Character.getNumericValue(num1.charAt(i)) : 0;
            int y = j >= 0 ? Character.getNumericValue(num2.charAt(j)) : 0;
            int digit = x + y + carry;
            carry = digit / 10;
            
            sb.insert(0, digit % 10);
            i--;
            j--;
        }
        
        while(i >= 0) {
            int digit = Character.getNumericValue(num1.charAt(i)) + carry;
            sb.insert(0, digit % 10);
            carry = digit / 10;
        }
        while(j >= 0) {
            int digit = Character.getNumericValue(num1.charAt(j)) + carry;
            sb.insert(0, digit % 10);
            carry = digit / 10;
        }
        if(carry != 0) sb.insert(0, carry);
        
        return sb.toString();
    }
}

//My Solution: 1刷
public class Solution
{
    public String addStrings(String num1, String num2)
    {
        if(num1 == null || num1.length() == 0)
            return num2;
        if(num1 == null || num1.length() == 0)
            return num2;
            
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<Integer> result = new Stack<>();
        
        for(int i = 0; i < num1.length(); i++)
            stack1.push(num1.charAt(i));
        for(int i = 0; i < num2.length(); i++)
            stack2.push(num2.charAt(i));
        
        int carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty())
        {
            int x = !stack1.isEmpty() ? Character.getNumericValue(stack1.pop()) : 0;
            int y = !stack2.isEmpty() ? Character.getNumericValue(stack2.pop()) : 0;
            
            int digit = x + y + carry;
            carry = digit / 10;
            
            result.push(digit % 10);
        }
        
        while(!stack1.isEmpty())
        {
            int digit = Character.getNumericValue(stack1.pop()) + carry;
            carry = digit / 10;
            result.push(digit % 10);
        }
        
        while(!stack2.isEmpty())
        {
            int digit = Character.getNumericValue(stack2.pop()) + carry;
            carry = digit / 10;
            result.push(digit % 10);
        }
        
        if(carry != 0)
            result.push(carry);
        
        String s = "";
        while(!result.isEmpty())
        {
            s += Integer.toString(result.pop());
        }
        
        return s;
    }
}
