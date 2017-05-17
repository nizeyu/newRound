//Union Find
public class Solution {
    public class UF {
        private int[] id;
        private int[] sz;
        // set id of each object to itself (N array accesses)
        public UF(int N) {
            id = new int[N];
            sz = new int[N];
            for(int i = 0; i < N; ++i) {
                id[i] = i;
                sz[i] = 1;
            }
        }
        
        // chase parent pointers until (depth of i array access)
        private int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]];
                // make every other node in path point to its grandparent(thereby halving path length)
                i = id[i];
            }
            return i;
        }
        
        // check if p and q have same root (depth of p and q array accesses)
        public boolean connected(int p, int q) { 
            return root(p) == root(q);
        }
        
        // change root of p to point to root of q (depth of p and q array accesses)
        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
            else               { id[j] = i; sz[i] += sz[j]; }
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
    	UF uf = new UF(n);
    	for(int[] edge : edges) {
    		if(uf.connected(edge[0], edge[1]))
    			return false;
    		else {
    			uf.union(edge[0], edge[1]);
    		}
    	}
    	return edges.length == n - 1;
    }
}
