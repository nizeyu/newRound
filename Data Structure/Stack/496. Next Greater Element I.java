//My Solution: Hash Map  ?Stack 怎么做？
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if(findNums == null || findNums.length == 0 || nums == null || nums.length == 0)
            return new int[0];
        
        int[] res = new int[findNums.length];
        int k = 0;
        boolean flag = false;
        
        //store nums in map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) 
            map.put(nums[i], i);
        
        for(int i = 0; i < findNums.length; i++) {
            flag = false;
            int index = map.get(findNums[i]);
            
            if(index + 1 == nums.length && k < res.length) {
                res[k++] = -1;
                continue;
            }
            
            //find the first greater number to its right
            for(int j = index + 1; j < nums.length; j++) {
                if(nums[j] > findNums[i] && k < res.length) {
                    System.out.println(nums[j]);
                    res[k++] = nums[j];
                    flag = true;
                    break;
                }
            }
            
            if(!flag && k < res.length)
                res[k++] = -1;
        }
        return res;
    }
}
