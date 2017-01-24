//先满足greed小的孩子
public class Solution
{
    public int findContentChildren(int[] g, int[] s)
    {
        if(g == null || g.length == 0 || s == null || s.length == 0)
            return 0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int gg = 0;
        for(int ss = 0; ss < s.length && gg < g.length; ss++)
        {
            if(s[ss] >= g[gg]) gg++;
        }
        return gg;
    }
}
