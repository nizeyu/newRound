//Method 1: Stack
//Iterate the expression from tail, whenever encounter a character before '?', 
//calculate the right value and push back to stack.
public class Solution {
    public String parseTernary(String expression) {
        if(expression == null || expression.length() == 0)
            return "";
            
        Stack<Character> stack = new Stack<>();
        for(int i = expression.length()-1; i >= 0; --i) {
            char c = expression.charAt(i);
            if(!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();//pop '?'
                char left = stack.pop();
                stack.pop();//pop ':'
                char right = stack.pop();
                
                if(c == 'T')
                    stack.push(left);
                else
                    stack.push(right);
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack.peek());
    }
}
