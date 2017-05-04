//My Solution
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0)
            return res;
        
        backtracking(n, n, "", res);
        
        return res;
    }
    
    private void backtracking(int i, int j, String s, List<String> res) {
        if(i > j)//注意
            return;
        
        if(i == 0 && j == 0)
            res.add(s);
        else {
            if(i > 0)
                backtracking(i-1, j, s + '(', res);
            if(j > 0)
                backtracking(i, j-1, s + ')', res);
        }
    }
}
