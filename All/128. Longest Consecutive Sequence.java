public class Solution
{
    public int longestConsecutive(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        QuickUnionUF uf = new QuickUnionUF(nums.length);
        
        for(int i = 0; i < nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i], i);
                
                if(map.containsKey(nums[i] - 1))
                    uf.union(i, map.get(nums[i] - 1));
                    
                if(map.containsKey(nums[i] + 1))
                    uf.union(i, map.get(nums[i] + 1));
            }
        }
        return uf.getMaxSize();
    }
}

class QuickUnionUF
{
    private int[] id;
    private int[] sz;
    private int max;
    
    public QuickUnionUF(int N)
    {
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
        max = 1;
    }
    
    private int root(int i)
    {
        while(i != id[i])
        {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }
    
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }
    }
    
    public int getMaxSize()
    {
        int max = 0;
        for(int i = 0; i < id.length; i++)
            max = Math.max(max, sz[i]);
        
        return max;
    }
}
