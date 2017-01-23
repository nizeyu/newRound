public class Solution
{
    public String frequencySort(String s)
    {
        if(s == null || s.length() == 0)
            return "";
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b)->(b.getValue() - a.getValue()));
        for(Map.Entry<Character, Integer> entry : map.entrySet())
            maxHeap.add(entry);
        
        StringBuilder sb = new StringBuilder();
        
        while(!maxHeap.isEmpty())
        {
            Map.Entry<Character, Integer> e = maxHeap.poll();
            for(int i = 0; i < e.getValue(); i++)
                sb.append(e.getKey());
        }
        
        return sb.toString();
    }
}
