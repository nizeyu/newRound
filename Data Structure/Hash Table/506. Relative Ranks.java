//My Solution:
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if(nums == null || nums.length == 0)
            return new String[0];
        
        String[] res = new String[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        for(int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
            map.put(nums[i], i);
        }

        int num = 1; 
        while(!q.isEmpty()) {
            int index = map.get(q.poll());
            if(num == 1)
               res[index] = "Gold Medal";
            else if(num == 2)
               res[index] = "Silver Medal";
            else if(num == 3)
               res[index] = "Bronze Medal";
            else
               res[index] = Integer.toString(num);
            num++;
        }
        
        return res;
    }
}
