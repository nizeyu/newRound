public class Solution
{
    public String decodeString(String s)
    {
        if(s == null || s.length() == 0)
            return "";
        
        String result = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                int cnt = 0;
                while(Character.isDigit(s.charAt(i)))
                {
                    cnt = 10 * cnt + (s.charAt(i) - '0');
                    i++;
                }
                countStack.push(cnt);
                i--;
            }
            else if(s.charAt(i) == '[')
            {
                resStack.push(result);
                result = "";
            }
            else if(s.charAt(i) == ']')
            {
                StringBuilder sb = new StringBuilder (resStack.pop());
                int repeatNum = countStack.pop();
                for (int j = 0; j < repeatNum; j++)
                    sb.append(result);
                result = sb.toString();
            }
            else
            {
                result += s.charAt(i);
            }
        }
        return result;
    }
}
