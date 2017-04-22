public class Solution {
    public String convertToTitle(int n) {
        if(n < 1)
            return "";
        
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            n--;
            sb.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return sb.toString();
    }
}
