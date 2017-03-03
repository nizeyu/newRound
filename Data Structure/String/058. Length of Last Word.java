public class Solution
{
    public int lengthOfLastWord(String s)
    {
        if(s == null || s.length() == 0)
            return 0;
        
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }
}

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int count = 0;
        int index = s.length() - 1;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ')
                index--;
            else
                break;
        }
        
        for(int i = index; i >= 0; i--) {
            if(s.charAt(i) != ' ')
                count++;
            else
                break;
        }
        return count;
    }
}
