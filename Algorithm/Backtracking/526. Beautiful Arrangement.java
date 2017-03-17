public class Solution {
    int count = 0;
    public int countArrangement(int N) {
        if(N == 0)
            return 0;
        
        backtracking(N, 1, new boolean[N+1]);
        
        return count;
    }
    
    private void backtracking(int N, int pos, boolean[] used) {
        if(pos > N) {
            count++;
            return;
        } else {
            for(int i = 1; i <= N; ++i) {
                if(used[i] == false && (i % pos == 0 || pos % i == 0)) {
                    used[i] = true;
                    backtracking(N, pos + 1, used);
                    used[i] = false;
                }
            }
        }
    }
}
