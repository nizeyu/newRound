//My Solution: sort
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        String a = strs[0];
        String b = strs[strs.length - 1];
        for(int i = 0; i < a.length(); i++) {
            if(b.length() > i && a.charAt(i) == b.charAt(i))
                sb.append(a.charAt(i));
            else
                break;
        }
        return sb.toString();
    }
}
