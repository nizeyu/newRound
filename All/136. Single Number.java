//My Solution 1: XOR
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++)
            res ^= nums[i];
        return res;
    }
}

//My Solution 2: HashSet
public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(!set.contains(num))
                set.add(num);
            else
                set.remove(num);
        }
        Iterator i = set.iterator();
        int res = (int)i.next();
        return res;
    }
}
