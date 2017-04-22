public class Solution
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        if(!wordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty())
        {
            if(beginSet.size() > endSet.size())
            {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for(String begin : beginSet)
            {
                for(String word : wordList)
                {
                    if(valid(begin, word))
                    {
                        if(endSet.contains(word))
                            return len + 1;
                        if(!visited.contains(word))
                        {
                            temp.add(word);
                            visited.add(word);
                        }
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
    
    private boolean valid(String a, String b)
    {
        int e = 0;
        for(int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i) != b.charAt(i))
                e++;
            if(e > 1)
                return false;
        }
        return true;
    }
}
