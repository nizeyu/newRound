//My Solution
public class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0)
            return "";
        
        Map<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Character, Integer>>() {
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            }
        );
        
        pq.addAll(map.entrySet());
        
        Comparator<Map.Entry<Character, Integer>> valueComparator = new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            Map.Entry entry = pq.poll();
            for(int i = 0; i < (int)entry.getValue(); ++i)
                sb.append(entry.getKey());
        }
        
        return sb.toString();
    }
}
