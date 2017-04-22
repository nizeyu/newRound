//Method 1: UF
public class Solution {
    public int countComponents(int n, int[][] edges) {
        
        QuickUnionUF uf = new QuickUnionUF(n);
        for(int[] edge : edges) {
            if(!uf.connected(edge[0], edge[1]))
                uf.union(edge[0], edge[1]);
        }
        return uf.getComponents();
    }
    
    class QuickUnionUF {
        private int[] id;
        private int[] sz;
        
        public QuickUnionUF(int N) {
            id = new int[N];
            sz = new int[N];
            for(int i = 0; i < N; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }
        
        private int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        
        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }
        
        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (i == j) return;
            if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
            else               { id[j] = i; sz[i] += sz[j]; }
        }
        
        public int getComponents() {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < id.length; i++)
                set.add(root(id[i]));
            return set.size();
        }
    }
}
