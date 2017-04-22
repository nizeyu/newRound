public class Solution
{
    public int titleToNumber(String s)
    {
        int col = 0;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            char x = s.charAt(i);
            col += (x -'A'+ 1) * (int)Math.pow(26, s.length() - i - 1);
        }
        return col;
    }
}
