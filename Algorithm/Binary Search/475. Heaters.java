//My Solution
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < houses.length; i++) {
            int index = lowerBound(heaters, houses[i]);
            
            int dist1 = index - 1 >= 0 ? houses[i] - heaters[index-1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - houses[i] : Integer.MAX_VALUE;
            
            max = Math.max(max, Math.min(dist1, dist2));
        }
        return max;
    }
    
    private int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            
            if(target <= nums[mid])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
