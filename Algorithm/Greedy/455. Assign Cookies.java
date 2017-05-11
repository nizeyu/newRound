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

//My Solution
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int j = 0;
        int count = 0;
        for(int i = 0; i < g.length; i++) {
            while(j < s.length && s[j] < g[i])
                j++;
            
            if(j >= s.length)
                break;
                
            count++;
            j++;
        }
        return count;
    }
}
