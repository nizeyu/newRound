public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if(n == 0)
            return res;
        if(n == 1) {
            res.add(1);
            return res;
        }
        
        int prefix = 1 << (n-1);
        res = grayCode(n-1);
        for(int i = res.size() - 1; i >= 0; i--)
            res.add(prefix + res.get(i));
        
        return res;
    }
}
