public class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        if(strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs)
        {
            char[] x = str.toCharArray();
            Arrays.sort(x);
            String s = String.valueOf(x);
            if(!map.containsKey(s))
                map.put(s, new ArrayList<String>());
            
            map.get(s).add(str);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}
