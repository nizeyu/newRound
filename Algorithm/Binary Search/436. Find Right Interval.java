/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution
{
    public int[] findRightInterval(Interval[] intervals)
    {
        if(intervals == null || intervals.length == 0)
            return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] starts = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++)
        {
            map.put(intervals[i].start, i);
            starts[i] = intervals[i].start;
        }
        Arrays.sort(starts);
        
        int[] result = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++)
        {
            int end = intervals[i].end;
            int start = binarySearch(starts, end);
            if(start < end)
                result[i] = -1;
            else
                result[i] = map.get(start);
        }
        return result;
    }
    
    public int binarySearch(int[] starts, int target)
    {
        int l = 0;
        int r = starts.length - 1;
        while(l < r)
        {
            int mid = l + (r - l) / 2;
            if(starts[mid] == target)
                return starts[mid];
            if(starts[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return starts[l];
    }
}
