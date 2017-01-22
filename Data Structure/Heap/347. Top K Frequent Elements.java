public class Solution
{
    public List<Integer> topKFrequent(int[] nums, int k)
    {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
            new PriorityQueue<>((a, b)->(b.getValue() - a.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            maxHeap.add(entry);
        
        for(int i = 0; i < k; i++)
        {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            result.add(entry.getKey());
        }
        return result;
    }
}
