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

//Method 2: DFS
public class Solution {
    public String parseTernary(String expression) {
        if(expression == null || expression.length() == 0)
            return expression;
            
        char[] exp = expression.toCharArray();
        
        return DFS(exp, 0, exp.length - 1) + "";
    }
    
    public char DFS(char[] c, int start, int end) {
        if(start == end)
            return c[start];
        
        int count = 0;
        int i = start;
        for(; i <= end; ++i) {
            if(c[i] == '?') {
                count++;
            } else if(c[i] == ':'){
                count--;
                if(count == 0)
                    break;
            }
        }
        return c[start] == 'T'?DFS(c, start + 2, i - 1) : DFS(c, i + 1, end);
    }
}
