// Self
class UnionFind {
	public int[] id;
	public int[] size;
	
	public UnionFind(int n) {
		id = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
		}	
	}
	
	// chase parent pointers until (depth of i array access)
	public int find(int i) {
		while (id[i] != i) {
			// make every other node in path point to its grandparent(thereby halving path length)
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	// change root of p to point to root of q (depth of p and q array accesses)
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (size[i] < size[j]) {
			id[i] = j;
			size[j] += size[i];
		} else {
			id[j] = i;
			size[i] += size[j];
		}
	}
	
	// check if p and q have same root (depth of p and q array accesses)
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
}

public class Solution {
    public int findCircleNum(int[][] M) {
        int m = M.length;
        
        UnionFind uf = new UnionFind(m);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (uf.id[i] == i) {
                count++;
            }
        }
        
        return count;
    }
}
