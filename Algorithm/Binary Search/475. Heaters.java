public class Solution
{
    public int findRadius(int[] houses, int[] heaters)
    {
        Arrays.sort(heaters);
        
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < houses.length; i++)
        {
            int index = Arrays.binarySearch(heaters, houses[i]);
            int min = Integer.MAX_VALUE;
            if(index < 0)
                index = -(index + 1);
    
            int dist1 = index - 1 >= 0 ? houses[i] - heaters[index-1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - houses[i] : Integer.MAX_VALUE;
            
            result = Math.max(result, Math.min(dist1, dist2));    
        }
        return result;
    }
}
