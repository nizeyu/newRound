public class Solution
{
    public List<Integer> findMinHeightTrees(int n, int[][] edges)
    {
        List<Integer> result = new ArrayList<>();
        
        if(n == 1)
        {
            result.add(0);
            return result;
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
            
        int [] inDegree = new int [n];
        
        for(int[] edge: edges)
        {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[0]]++;
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[1]]++;
        }
        
        Queue<Integer> leaves = new LinkedList<>();
        for(int i = 0; i < n; i++)
            if(inDegree[i] == 1)
                leaves.offer(i);
        
        while(n > 2)
        {
            int size = leaves.size();    
            for(int i = 0; i < size; i++)
            {
                int x = leaves.poll();
                n--;
                for(int leaf: graph.get(x))
                {
                    if(--inDegree[leaf] == 1)
                        leaves.offer(leaf);
                }
            }
        }
        
        while(!leaves.isEmpty())
            result.add(leaves.poll());
            
        return result;
    }
}
