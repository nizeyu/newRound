//My Solution
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
    public List<Interval> merge(List<Interval> intervals)
    {
        if(intervals == null || intervals.size() <= 1)
            return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2)
            {
                return Integer.compare(i1.start, i2.start);
            }
        });
        
        List<Interval> result = new ArrayList<>();
        Interval pre = intervals.get(0);
        
        for(int i = 1; i < intervals.size(); i++)
        {
            if(i > 0 && intervals.get(i).start <= pre.end)
            {
                int s = pre.start;
                int e = Math.max(intervals.get(i).end, pre.end);
                pre = new Interval(s, e);
            }
            else
            {
                result.add(pre);
                pre = intervals.get(i);
            }
            
        }
        result.add(pre);
        return result;
    }
}
