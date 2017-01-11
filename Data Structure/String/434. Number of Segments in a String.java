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
