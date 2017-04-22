/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution
{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        if(node == null)
            return null;
        
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        
        UndirectedGraphNode source = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, source);
        
        while(!q.isEmpty())
        {
            UndirectedGraphNode x = q.poll();
            List<UndirectedGraphNode> neighbors = x.neighbors;
            
            for(UndirectedGraphNode neighbor: neighbors)
            {
                if(map.containsKey(neighbor))
                    map.get(x).neighbors.add(map.get(neighbor));
                else
                {
                    UndirectedGraphNode clone = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, clone);
                    map.get(x).neighbors.add(clone);
                    q.offer(neighbor);
                }
            }
        }
        return source;
    }
}
