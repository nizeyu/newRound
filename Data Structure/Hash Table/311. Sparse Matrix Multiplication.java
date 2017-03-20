//Method 1: hash table
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] != 0) {
                    map.put(j, A[i][j]);
                }
            }
            
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int row = entry.getKey();
                for(int k = 0; k < B[0].length; k++) {
                    if(B[row][k] != 0) {
                        res[i][k] += entry.getValue() * B[row][k];
                    }
                }
            }
            map.clear();
        }
        
        return res;
    }
}

//Method 2: 直接
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] != 0) {
                    for(int k = 0; k < B[0].length; k++) {
                        if(B[j][k] != 0) {
                            res[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return res;
    }
}
