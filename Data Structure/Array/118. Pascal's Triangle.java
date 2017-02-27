//My Solution
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows < 1)
            return res;
        
        List<Integer> t = new ArrayList<>();
        t.add(1);
        res.add(t);
        
        for(int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j <= i - 2; j++) {
                int num = res.get(i-2).get(j-1) + res.get(i-2).get(j);
                temp.add(num);
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}

public class Solution
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> result = new ArrayList<>();
        
        if(numRows <= 0)
            return result;
        
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        
        result.add(prev);
        
        for(int i = 2; i <= numRows; i++)
        {
            List<Integer> curr = new ArrayList<>();
            
            curr.add(1);
            
            for(int j = 0; j < prev.size() - 1; j++)
            {
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1);
            
            prev = curr;
            result.add(prev);
        }
        return result;   
    }
}
