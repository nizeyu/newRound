//My Solution
public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0)
            return "";
        
        char[] str = s.toCharArray();
        int i = 0;
        int j = str.length - 1;
        while(i < j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
            i++;
            j--;
        }
        return new String(str);
    }
}
