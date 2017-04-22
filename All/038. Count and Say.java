//My Solution: StringBuilder 效率更高，每次在后面加  而String会新建一个对象，有复制的耗时
public class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        
        String strs = countAndSay(n - 1) + "*";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        
        for(int i = 0; i < strs.length() - 1; i++) {
            if(strs.charAt(i) != strs.charAt(i+1)) {
                sb.append(count);
                sb.append(strs.charAt(i));
                count = 1;
            } else {
                count++;
            }
        }
        return sb.toString();
    }
}
