//My Solution
public class Solution
{
    public int findPoisonedDuration(int[] timeSeries, int duration)
    {
        if(timeSeries == null || timeSeries.length == 0 || duration == 0)
            return 0;
        
        int result = 0;
        int end = timeSeries[0];
        for(int i = 0; i < timeSeries.length; i++)
        {
            if(i > 0 && timeSeries[i] < end)
            {
                result += duration - (end - timeSeries[i]);
            }
            else
            {
                result += duration;
            }
            end = timeSeries[i] + duration;
        }
        return result;
    }
}

//My Solution
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0 || duration <= 0)
            return 0;
        
        int count = 0;
        for(int i = 0; i < timeSeries.length - 1; ++i) {
            if(timeSeries[i] + duration > timeSeries[i+1])
                count += timeSeries[i+1] - timeSeries[i];
            else
                count += duration;
        }
        return count + duration;
    }
}
