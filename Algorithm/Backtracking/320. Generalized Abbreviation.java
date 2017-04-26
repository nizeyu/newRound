//backtracking
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        
        DFS(res, new StringBuilder(), word.toCharArray(), 0, 0);
        
        return res;
    }
    
    private void DFS(List<String> res, StringBuilder sb, char[] c, int i, int count) {
        int len = sb.length();
        if(i == c.length) {
            if(count > 0)
                sb.append(count);
            res.add(sb.toString());
        } else {
            DFS(res, sb, c, i + 1, count + 1);
            if(count != 0)
                sb.append(count);
            
            DFS(res, sb.append(c[i]), c, i + 1, 0);
        }
        sb.setLength(len);
    }
}
