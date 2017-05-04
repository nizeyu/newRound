//backtracking
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        
        backtracking(k, n, 1, new ArrayList<>(), res);
        
        return res;
    }
    
    private void backtracking(int k, int n, int start, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size() == k && n == 0) {
            res.add(new ArrayList<>(temp));
        } else {
            for(int i = start; i <= 9; ++i) {
                temp.add(i);
                backtracking(k, n-i, i+1, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
}

//wrong answer
public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        if(k < 1 || n < 1)
            return res;
        
        backtracking(k, n, 1, new ArrayList<>(), new boolean[11]);
        
        return res;
    }
    
    private void backtracking(int k, int n, int i, List<Integer> temp, boolean[] used) {
        if(temp.size() == k) {
            int sum = 0;
            for(int j = 0; j < k; ++j) {
                sum += temp.get(j);
            }
            //System.out.print(sum);    
            if(sum == n)
                res.add(new ArrayList<>(temp));
        } else {
            for(int j = i; j < 10; ++j) {
                if(used[j] == false) {
                    temp.add(j);
                    used[j] = true;
                    backtracking(k, n, i+1, temp, used);
                    used[j] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
