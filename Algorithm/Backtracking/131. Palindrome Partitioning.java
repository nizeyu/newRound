public class Solution
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> result = new ArrayList<>();
        
        if(s == null || s.length() == 0)
            return result;
        
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void partition(String s, int start, List<String> tempList, List<List<String>> result)
    {
        if(start == s.length())
            result.add(new ArrayList<>(tempList));
        else
        {   
            for(int i = start + 1; i <= s.length(); i++)//<=
            {
                String str = s.substring(start, i);
                if(isPalindrome(str))
                {
                    tempList.add(str);
                    partition(s, i, tempList, result);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
    
    private boolean isPalindrome(String str)
    {
        int l = 0;
        int r = str.length() - 1;
        
        while(l < r)
        {
            if(str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
