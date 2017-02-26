//My Solution
public class Solution {
    public int countSegments(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') 
                count++;
            while(i < s.length() && s.charAt(i) != ' ')
                i++;
        }
        return count;
    }
}

//discuss
public class Solution
{
    public int countSegments(String s)
    {
        String trimmed = s.trim();
        if(trimmed.length() == 0)
            return 0;
        return trimmed.split("\\s+").length;
    }
}
