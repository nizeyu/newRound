public class Solution
{
    public int characterReplacement(String s, int k)
    {
        if(s == null || s.length() == 0)
            return 0;
        
        int result = 0, maxCount = 0, start = 0;
        int[] count = new int[26];
        for(int end = 0; end < s.length(); end++)
        {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while(end - start + 1 - maxCount > k)
            {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
